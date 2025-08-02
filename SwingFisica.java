package com.mycompany.swingfisica;

import java.awt.*; 
import javax.swing.*; 

public class SwingFisica extends JFrame {

    // Declaração dos componentes da interface
    private JLabel Q1Label;
    private JTextField Q1Valor;
    private JLabel Q2Label;
    private JTextField Q2Valor;
    private JLabel Q1PosicaoEixoX;
    private JTextField Q1ValorPosicao;
    private JLabel Q2PosicaoEixoX;
    private JTextField Q2ValorPosicao;
    private JLabel labelPontoP;
    private JTextField posicaoXPontoP;
    private JTextField posicaoYPontoP;
    private JButton botaoCalcular;
    private JButton botaoResetar;
    private JPanel painelPontoP;
    private JLabel Q1ValorUnidMed;
    private JLabel Q1PosXUnidMed;
    private JLabel Q2ValorUnidMed;
    private JLabel Q2PosXUnidMed;
    private JLabel pPosXUnidMed;
    private JLabel pPosYUnidMed;
    private JMenuBar barraDeMenu;
    private JMenu menuAjuda;
    private JMenuItem menuDuvida;
    
    // Constante da eletrostática 
    static final double VALOR_K = 8.99e9;

    public SwingFisica() {
        //Criando a janela
        super("Calculadora de Campo Elétrico"); 
        setSize(650, 480); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new GridBagLayout()); 
        GridBagConstraints cons = new GridBagConstraints(); 

        // Criando o menu na parte superior da tela
        barraDeMenu = new JMenuBar();
        menuAjuda = new JMenu("Ajuda");
        menuDuvida = new JMenuItem("Como devem ser os valores de entrada");

        // Ação do item de menu 
        menuDuvida.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                null,
                "Para inserir corretamente os valores das cargas e posições:\n\n"
                + "- Use notação científica. Exemplo: 3.2e-19 (3,2 × 10⁻¹⁹)\n"
                + "- Use ponto (.) como separador decimal\n"
                + "- A letra 'e' representa potência de 10\n\n"
                + "Exemplo correto: 1.6e-19\nExemplo incorreto: 1,6 x 10^-19",
                "Instruções de Entrada",
                JOptionPane.INFORMATION_MESSAGE);
        });

        // Adiciona item ao menu e define na janela
        menuAjuda.add(menuDuvida);
        barraDeMenu.add(menuAjuda);
        setJMenuBar(barraDeMenu);
        

        //CAMPOS DE ENTRADA

        // Q1 (carga negativa)
        Q1Label = new JLabel("Valor da carga negativa (Q1):");
        Q1Valor = new JTextField();
        Q1Valor.setPreferredSize(new Dimension(200, 30));
        Q1ValorUnidMed = new JLabel("C"); // Unidade: Coulomb

        Q1PosicaoEixoX = new JLabel("Posição do eixo X (de Q1):");
        Q1ValorPosicao = new JTextField();
        Q1ValorPosicao.setPreferredSize(new Dimension(200, 30));
        Q1PosXUnidMed = new JLabel("m"); // Unidade: metros

        // Q2 (carga positiva)
        Q2Label = new JLabel("Valor da carga positiva (Q2):");
        Q2Valor = new JTextField();
        Q2Valor.setPreferredSize(new Dimension(200, 30));
        Q2ValorUnidMed = new JLabel("C");

        Q2PosicaoEixoX = new JLabel("Posição do eixo X (de Q2):");
        Q2ValorPosicao = new JTextField();
        Q2ValorPosicao.setPreferredSize(new Dimension(200, 30));
        Q2PosXUnidMed = new JLabel("m");

        // Coordenadas do ponto P
        labelPontoP = new JLabel("Digite a posição (X e Y) do ponto P:");
        posicaoXPontoP = new JTextField();
        posicaoXPontoP.setPreferredSize(new Dimension(120, 30));
        posicaoYPontoP = new JTextField();
        posicaoYPontoP.setPreferredSize(new Dimension(120, 30));
        pPosXUnidMed = new JLabel("m");
        pPosYUnidMed = new JLabel("m");

        // Criando os botões
        botaoCalcular = new JButton("Calcular");
        botaoResetar = new JButton("Resetar");
        botaoResetar.setForeground(Color.RED); 

        //POSICIONAMENTO DOS COMPONENTES COM GridBagLayout 
        cons.insets = new Insets(10, 10, 30, 30);
        cons.anchor = GridBagConstraints.LINE_END;

        // Q1: valor e unidade
        cons.gridx = 0; cons.gridy = 0;
        add(Q1Label, cons);
        cons.gridx = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        add(Q1Valor, cons);
        cons.gridx = 2;
        cons.fill = GridBagConstraints.NONE;
        add(Q1ValorUnidMed, cons);

        // Q1: posição e unidade
        cons.gridx = 0; cons.gridy = 1;
        add(Q1PosicaoEixoX, cons);
        cons.gridx = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        add(Q1ValorPosicao, cons);
        cons.gridx = 2;
        cons.fill = GridBagConstraints.NONE;
        add(Q1PosXUnidMed, cons);

        // Q2: valor e unidade
        cons.gridx = 0; cons.gridy = 2;
        add(Q2Label, cons);
        cons.gridx = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        add(Q2Valor, cons);
        cons.gridx = 2;
        cons.fill = GridBagConstraints.NONE;
        add(Q2ValorUnidMed, cons);

        // Q2: posição e unidade
        cons.gridx = 0; cons.gridy = 3;
        add(Q2PosicaoEixoX, cons);
        cons.gridx = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        add(Q2ValorPosicao, cons);
        cons.gridx = 2;
        cons.fill = GridBagConstraints.NONE;
        add(Q2PosXUnidMed, cons);

        // Ponto P: campo X, campo Y, e unidades
        painelPontoP = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelPontoP.add(labelPontoP);
        painelPontoP.add(posicaoXPontoP);
        painelPontoP.add(pPosXUnidMed);
        painelPontoP.add(posicaoYPontoP);
        painelPontoP.add(pPosYUnidMed);

        cons.gridx = 0; cons.gridy = 4; cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        add(painelPontoP, cons);

        // adicionando os botões na janela
        cons.gridx = 0; cons.gridy = 5; cons.gridwidth = 1;
        cons.anchor = GridBagConstraints.CENTER;
        add(botaoCalcular, cons);
        cons.gridx = 1;
        add(botaoResetar, cons);

        //Lógica do botão CALCULAR 
        botaoCalcular.addActionListener(e -> {
            if (Q1Valor.getText().isEmpty() || Q1ValorPosicao.getText().isEmpty() ||
                Q2Valor.getText().isEmpty() || Q2ValorPosicao.getText().isEmpty() ||
                posicaoXPontoP.getText().isEmpty() || posicaoYPontoP.getText().isEmpty()) {
                
                // Caso campos estejam vazios
                JOptionPane.showMessageDialog(null, "Certifique-se de ter preenchido todos os campos corretamente!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    
                    // Leitura e conversão dos valores
                    double Q1 = Double.parseDouble(Q1Valor.getText());
                    double Q1Pos = Double.parseDouble(Q1ValorPosicao.getText());
                    double Q2 = Double.parseDouble(Q2Valor.getText());
                    double Q2Pos = Double.parseDouble(Q2ValorPosicao.getText());
                    double XPonto = Double.parseDouble(posicaoXPontoP.getText());
                    double YPonto = Double.parseDouble(posicaoYPontoP.getText());

                    // Correção de sinais
                    if (Q1 > 0) Q1 = -Q1;
                    if (Q2 < 0) Q2 = -Q2;
                    if (Q1Pos > 0) Q1Pos = -Q1Pos;
                    if (Q2Pos < 0) Q2Pos = -Q2Pos;

                    // Cálculo do campo elétrico resultante
                    double resultado = Math.pow(XPonto, 2) + Math.pow(YPonto, 2);
                    double er = (2 * VALOR_K * Q2 * XPonto) / Math.pow(resultado, 1.5);

                    // Formata a saída em notação científica
                    String resultadoFormatado = String.format("%.3e", er);

                    // Exibe o resultado
                    JOptionPane.showMessageDialog(null, "Er = " + resultadoFormatado + " N/C\nÂngulo θ: 180°", "Resultado da conta", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    //Caso tenha simbolos nao permitidos nos campos 
                    JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos contenham números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Botão RESETAR: limpa todos os campos 
        botaoResetar.addActionListener(e -> {
            Q1Valor.setText("");
            Q1ValorPosicao.setText("");
            Q2Valor.setText("");
            Q2ValorPosicao.setText("");
            posicaoXPontoP.setText("");
            posicaoYPontoP.setText("");
        });
        
        // Torna a janela visível
        setVisible(true);
    }
}
