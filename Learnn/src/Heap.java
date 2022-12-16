import java.util.Scanner;

public class Heap {
    // 02195076050 Yasin Akcil


    public int[] toArray(String s){
        String[] sayilar = s.split(",");
        int[] diziSayi = new int[sayilar.length];
        for (int i=0;i<sayilar.length;i++){
            diziSayi[i] = Integer.parseInt(sayilar[i]);
        }

        return diziSayi;
    }

    public boolean ucluMinHeapMi(int[] array) {
        int n = array.length;

        // Dizinin boş olup olmadığını kontrol edin
        if (n == 0) {
            return true;
        }

        // Her düğüm için, en küçük çocuğun düğüm değerinden küçük olup olmadığını kontrol edin
        for (int i = 0; i < n; i++) {
            // Düğümün çocuklarının indekslerini hesaplayın
            int child1 = 3 * i + 1;
            int child2 = 3 * i + 2;
            int child3 = 3 * i + 3;

            // Eğer düğüm çocukları varsa, en küçük çocuğun düğüm değerinden küçük olup olmadığını kontrol edin
            if (child1 < n && array[child1] < array[i]) {
                return false;
            }
            if (child2 < n && array[child2] < array[i]) {
                return false;
            }
            if (child3 < n && array[child3] < array[i]) {
                return false;
            }
        }

        return true;
    }
    public void minHeapYap(int[] dizi) {
        int n = dizi.length;

        // Dizinin ortasından başlayarak tüm öğeleri gezerek min heap yapısını oluşturalım
        for (int i = n / 2 - 1; i >= 0; i--)
            duzenle(dizi, n, i);
    }

    public void duzenle(int[] dizi, int n, int i) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && dizi[leftChild] < dizi[smallest])
            smallest = leftChild;

        if (rightChild < n && dizi[rightChild] < dizi[smallest])
            smallest = rightChild;

        if (smallest != i) {
            int temp = dizi[i];
            dizi[i] = dizi[smallest];
            dizi[smallest] = temp;

            duzenle(dizi, n, smallest);
        }
    }

    public static void main(String[] args) {

        Heap heap = new Heap();
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        int[] dizi = heap.toArray(st);

        if(heap.ucluMinHeapMi(dizi)){
            System.out.println("Dizi 3lu heap yapisina uygundur!");
        }else {
            System.out.println("Dizi 3lu heap yapisina uygun degildir!");
            heap.minHeapYap(dizi);
            System.out.println("duzenlenmis dizi:");
            for (int i:dizi) {
                System.out.print(i+",");
            }

        }


    }



}
