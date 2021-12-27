package colheita;

import java.util.Arrays;

public class Selva {

  public static void main(final String[] args) {
	  
// Criando ilhas
    final int[][] ilha1 = {
      { 1, 3, 3 },
      { 2, 1, 4 },
      { 0, 6, 4 }
    };

    final int[][] ilha2 = {
      { 1, 3, 1, 5 },
      { 2, 2, 4, 1 },
      { 5, 0, 2, 3 },
      { 0, 6, 1, 2}
    };

    final int[][] ilha3 = {
      { 10, 33, 13, 15 },
      { 22, 21,  4,  1 },
      {  5,  0,  2,  3 },
      {  0,  6, 14,  2}
    };

    System.out.println("------ Selva ilha 1 ------");
    processaSelva(ilha1);
    System.out.println("------ Selva ilha 2 ------");
    processaSelva(ilha2);
    System.out.println("------ Selva ilha 3 ------");
    processaSelva(ilha3);
  }

// Metodo de processamento da ilha(Matriz)
  private static void processaSelva(final int[][] ilha) {
	  imprimeSelva(ilha);
	  System.out.print("Caminho percorrido = ");

    final int linhas = ilha.length;
    final int columns = ilha[0].length;

    int total = 0;
    int linhaAtual = 0;
    int ultimaLinha = 0;

// Lendo linhas e colunas
    for (int i = 0; i < columns; i++) {
      int maiorNaColuna = 0;
      for (int j = 0; j < linhas; j++) {
        final int diff = getDiff(ultimaLinha, j);
        if((i == 0 || diff < 2) && ilha[j][i] > maiorNaColuna) {
          maiorNaColuna = ilha[j][i];
          linhaAtual = j;
        }
      }
      ultimaLinha = linhaAtual;
      System.out.print("{" + ultimaLinha + "," + i + "}");
      total += maiorNaColuna;
    }
    System.out.println("");
    System.out.println("Total de bananas colhidas =" + total);
    System.out.println("");
  }

  private static int getDiff(final int i1, final int i2) {
    if(i1 > i2) {
      return i1 - i2;
    } else {
      return i2 - i1;
    }
  }

  private static void imprimeSelva(final int[][] matrix) {
    Arrays.stream(matrix).forEach(row -> {
      System.out.print("[");
      Arrays.stream(row).forEach(el -> System.out.print(" " + el + " "));
      System.out.println("]");
    });
  }
}
