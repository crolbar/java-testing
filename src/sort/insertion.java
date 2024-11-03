package sort;

public
class insertion
{
  public
    static void sort(int[] data)
    {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int cmp = data[i];

            while (j >= 0) {
                if (data[j] < cmp)
                    break;

                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = cmp;
        }
    }
}
