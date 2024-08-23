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

        runScript = ''
          ${pkgs.jdk}/bin/javac Hello.java && ${pkgs.jdk}/bin/java Hello
        '';
      in {
        default = pkgs.mkShell {
          packages = with pkgs; [
            jdk
            (pkgs.writeTextFile {
              name = "run";
              destination = "/bin/run";
              executable = true;
              text = runScript;
            })
          ];
        };
      }
    );

    packages = eachSystem (
      system: let
        pkgs = pkgsFor.${system};

        test = pkgs.stdenv.mkDerivation rec {
          pname = "test";
          version = "0.1";
          src = ./.;

          nativeBuildInputs = with pkgs; [
            jdk
          ];

          dontPatch = true;
          dontConfigure = true;

          buildPhase = ''
            javac Hello.java
          '';

          installPhase = ''
            mkdir -p $out/bin
            mv Hello.class $out/bin

            echo "#!/bin/sh" > $out/bin/${pname}
            echo "${pkgs.jdk}/bin/java -cp $out/bin Hello" >> $out/bin/${pname}
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
