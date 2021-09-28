package com.laplace.checkers;

public class Jogo {

    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
//  Posiciona as peças no tabuleiro

    private void criarPecas() {
        Integer[] parX = {0, 2, 4, 6};
        Integer[] imparX = {1, 3, 5, 7};
        Integer[] whiteFileira = {5, 6, 7};
        Integer[] darkFileira = {0, 1, 2};
        
        for (Integer y : whiteFileira) {
        if (y % 2 == 0) {
            for (Integer x: parX) {
                new Peca(this.tabuleiro.getCasa(x, y), Peca.PEDRA_VERMELHA);
            }
        } else {
            for (Integer x: imparX) {
                new Peca(this.tabuleiro.getCasa(x, y), Peca.PEDRA_VERMELHA);
            }
        }
        }

        for (Integer y: darkFileira) {
            if (y % 2 == 0) {
                for (Integer x: parX) {
                    new Peca(this.tabuleiro.getCasa(x, y), Peca.PEDRA_BRANCA);
                }
            } else {
                for (Integer x: imparX) {
                    new Peca(this.tabuleiro.getCasa(x, y), Peca.PEDRA_BRANCA);
                }
            }
        }
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        peca.mover(destino);
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
