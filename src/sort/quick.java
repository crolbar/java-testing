package sort;

public
class quick
{
  public
    static void sort(int[] data) { qs(data, 0, data.length - 1); }

  private
    static void qs(int[] data, int l, int r)
    {
        if (l >= r)
            return;

        int pi = pivot(data, l, r);

        qs(data, l, pi - 1);
        qs(data, pi + 1, r);
    }

  private
    static int pivot(int[] data, int l, int r)
    {
        int pivot = data[r];

        int idx = l - 1;

        for (int i = l; i < r; i++) {
            if (data[i] < pivot) {
                idx++;

                int tmp = data[i];
                data[i] = data[idx];
                data[idx] = tmp;
            }
        }

        idx++;
        data[r] = data[idx];
        data[idx] = pivot;

        return idx;
    }
}
