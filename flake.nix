{
  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs = {nixpkgs, ...}: let
    systems = ["x86_64-linux"];
    eachSystem = nixpkgs.lib.genAttrs systems;

    pkgsFor = eachSystem (
      system:
        import nixpkgs {inherit system;}
    );
  in {
    devShells = eachSystem (
      system: let
        pkgs = pkgsFor.${system};

        runScript = "./gradlew \"$@\"";
      in {
        default = pkgs.mkShell {
          packages = with pkgs; [
            jdk
            gradle
            jdt-language-server
            (pkgs.writers.writeBashBin "g" runScript)
          ];
        };
      }
    );

    packages = eachSystem (
      system: let
        pkgs = pkgsFor.${system};

        test = pkgs.stdenv.mkDerivation rec {
          pname = "java-testing";
          version = "0.1";
          src = ./.;

          nativeBuildInputs = with pkgs; [
            jdk
            gradle
          ];

          installPhase = ''
            mkdir -p $out/bin
            cp -r build/libs/*.jar $out/bin/${pname}.jar

            echo "#!/bin/sh" > $out/bin/${pname}
            echo "java -jar $out/bin/${pname}.jar \"\$@\"" >> $out/bin/${pname}
            chmod +x $out/bin/${pname}
          '';
        };
      in {
        inherit test;
        default = test;
      }
    );
  };
}
