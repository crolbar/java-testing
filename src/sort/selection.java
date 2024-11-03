package sort;

public
class selection
{
  public
    static void sort(int[] data)
    {
        for (int i = 0; i < data.length - 1; i++) {
            int lowestIdx = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[lowestIdx]) {
                    lowestIdx = j;
                }
            }

            if (lowestIdx == i)
                continue;

            int tmp = data[i];
            data[i] = data[lowestIdx];
            data[lowestIdx] = tmp;
        }
    }
}
