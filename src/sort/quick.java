package sort;

public class quick
{
    public static void sort(int[] data) { qs(data, 0, data.length - 1); }

    private static void qs(int[] data, int l, int r)
    {
        if (l >= r)
            return;

        int pi = pivot(data, l, r);

        qs(data, l, pi - 1);
        qs(data, pi + 1, r);
    }

    private static int pivot(int[] data, int l, int r)
    {
        int pivot = data[r];

        int i = l;

        for (int j = l; j < r; j++) {
            if (data[j] >= pivot)
                continue;

            int tmp = data[j];
            data[j] = data[i];
            data[i] = tmp;
        }

        data[r] = data[i];
        data[i] = pivot;

        return i;
    }
}
