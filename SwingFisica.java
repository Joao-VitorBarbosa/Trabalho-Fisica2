package com.mycompany.swingfisica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingFisica extends JFrame {

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

    static final double VALOR_K = 8.99e9;

    public SwingFisica() {
        super("calculadora");
        setSize(650, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        
        barraDeMenu = new JMenuBar();
        menuAjuda = new JMenu("Ajuda");
        menuDuvida = new JMenuItem("Como devem ser os valores de entrada");
        
        menuDuvida.addActionListener(e -> {
            
            JOptionPane.showMessageDialog(
                    null,
                    "Para inserir corretamente os valores das cargas e posições:\n\n"
                    + "- Use notação científica. Exemplo: 3.2e-19 (que significa 3,2 × 10⁻¹⁹)\n"
                    + "- Use ponto (.) como separador decimal, não vírgula(,)\n"
                    + "- A letra 'e' representa a potência de 10\n\n"
                    + "Exemplo correto: 1.6e-19\nExemplo incorreto: 1,6 x 10^-19",
                    "Instruções de Entrada",
                    JOptionPane.INFORMATION_MESSAGE); 
            });
        
        menuAjuda.add(menuDuvida);
        barraDeMenu.add(menuAjuda);
        setJMenuBar(barraDeMenu);

        // Criação dos componentes
        Q1Label = new JLabel("Valor da carga negativa (Q1):");
        Q1Valor = new JTextField();
        Q1Valor.setPreferredSize(new Dimension(200, 30));

        Q1PosicaoEixoX = new JLabel("Posição do eixo X (de Q1):");
        Q1ValorPosicao = new JTextField();
        Q1ValorPosicao.setPreferredSize(new Dimension(200, 30));

        Q1ValorUnidMed = new JLabel("C");
        Q1PosXUnidMed = new JLabel("m");

        Q2Label = new JLabel("Valor da carga positiva (Q2):");
        Q2Valor = new JTextField();
        Q2Valor.setPreferredSize(new Dimension(200, 30));

        Q2PosicaoEixoX = new JLabel("Posição do eixo X (de Q2):");
        Q2ValorPosicao = new JTextField();
        Q2ValorPosicao.setPreferredSize(new Dimension(200, 30));

        Q2ValorUnidMed = new JLabel("C");
        Q2PosXUnidMed = new JLabel("m");

        labelPontoP = new JLabel("Digite a posição (X e Y) do ponto P:");
        posicaoXPontoP = new JTextField();
        posicaoXPontoP.setPreferredSize(new Dimension(120, 30));
        posicaoYPontoP = new JTextField();
        posicaoYPontoP.setPreferredSize(new Dimension(120, 30));
        
        
        pPosXUnidMed = new JLabel("m");
        pPosYUnidMed = new JLabel("m");

        botaoCalcular = new JButton("Calcular");
        botaoResetar = new JButton("Resetar");
        botaoResetar.setForeground(Color.RED);

        // Adicionando componentes com GridBagConstraints
        cons.insets = new Insets(10, 10, 30, 30);
        cons.anchor = GridBagConstraints.LINE_END;

        // Q1 Label
        cons.gridx = 0;
        cons.gridy = 0;
        add(Q1Label, cons);

        // Q1 Valor
        cons.gridx = 1;
        cons.gridy = 0;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1.0;
        add(Q1Valor, cons);
        
        //Q1 Unidade de medida
        cons.gridx = 2;
        cons.gridy = 0;
        add(Q1ValorUnidMed, cons);

        // Q1 Posição
        cons.gridx = 0;
        cons.gridy = 1;
        cons.fill = GridBagConstraints.NONE;
        cons.weightx = 0;
        add(Q1PosicaoEixoX, cons);

        cons.gridx = 1;
        cons.gridy = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1.0;
        add(Q1ValorPosicao, cons);
        
        //Q1 unidade de medida posição
        cons.gridx = 2;
        cons.gridy = 1;
        add(Q1PosXUnidMed, cons);

        // Q2 Label
        cons.gridx = 0;
        cons.gridy = 2;
        cons.fill = GridBagConstraints.NONE;
        cons.weightx = 0;
        add(Q2Label, cons);

        // Q2 Valor
        cons.gridx = 1;
        cons.gridy = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1.0;
        add(Q2Valor, cons);
        
        //Q2 Unidade de medida
        cons.gridx = 2;
        cons.gridy = 2;
        add(Q2ValorUnidMed, cons);

        // Q2 Posição
        cons.gridx = 0;
        cons.gridy = 3;
        cons.fill = GridBagConstraints.NONE;
        cons.weightx = 0;
        add(Q2PosicaoEixoX, cons);

        cons.gridx = 1;
        cons.gridy = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1.0;
        add(Q2ValorPosicao, cons);
        
        //Q1 unidade de medida posição
        cons.gridx = 2;
        cons.gridy = 3;
        add(Q2PosXUnidMed, cons);

        // Cria um painel horizontal para label + campos do ponto P
        painelPontoP = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelPontoP.add(labelPontoP);
        painelPontoP.add(posicaoXPontoP);
        painelPontoP.add(pPosXUnidMed);
        painelPontoP.add(posicaoYPontoP);
        painelPontoP.add(pPosYUnidMed);

        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1.0;
        add(painelPontoP, cons);

        // Botões
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.anchor = GridBagConstraints.CENTER;
        add(botaoCalcular, cons);

        cons.gridx = 1;
        cons.gridy = 5;
        add(botaoResetar, cons);

        //ação do botão calcular
        botaoCalcular.addActionListener(e -> {
            
            if(Q1Valor.getText().isEmpty() ||
               Q1ValorPosicao.getText().isEmpty() ||
               Q2Valor.getText().isEmpty() ||
               Q2ValorPosicao.getText().isEmpty() ||
               posicaoXPontoP.getText().isEmpty() ||
               posicaoYPontoP.getText().isEmpty()){
   
                JOptionPane.showMessageDialog(null, "certifique-se de ter preenchido corretamente os campos !!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            } else {

                try {
                    double Q1 = Double.parseDouble(Q1Valor.getText());
                    double Q1Pos = Double.parseDouble(Q1ValorPosicao.getText());
                    double Q2 = Double.parseDouble(Q2Valor.getText());
                    double Q2Pos = Double.parseDouble(Q2ValorPosicao.getText());
                    double XPonto = Double.parseDouble(posicaoXPontoP.getText());
                    double YPonto = Double.parseDouble(posicaoYPontoP.getText());

                    // Corrige os sinais antes do cálculo
                    if (Q1 > 0) {
                        Q1 = -Q1;  // Q1 deve ser negativa
                    }
                    if (Q2 < 0) {
                        Q2 = -Q2;  // Q2 deve ser positiva
                    }
                    if (Q1Pos > 0) {
                        Q1Pos = -Q1Pos;  // Se posição do Q1 deve ser negativa, corrige aqui
                    }
                    if (Q2Pos < 0) {
                        Q2Pos = -Q2Pos;  // Se posição do Q2 deve ser positiva, corrige aqui
                    }

                    double resultado = Math.pow(XPonto, 2) + Math.pow(YPonto, 2);
                    double er = (2 * VALOR_K * Q2 * XPonto) / Math.pow(resultado, 1.5);
                    String resultadoFormatado = String.format("%.3e", er);

                    JOptionPane.showMessageDialog(null, "Er = " + resultadoFormatado + " N/C\n"
                            + "Ângulo θ: 180°", "Resultado da conta", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Certifique-se de que todos os campos contenham números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        
        // Ação do botão resetar
        botaoResetar.addActionListener(e -> {
            Q1Valor.setText("");
            Q1ValorPosicao.setText("");
            Q2Valor.setText("");
            Q2ValorPosicao.setText("");
            posicaoXPontoP.setText("");
            posicaoYPontoP.setText("");
        });

        setVisible(true);
    }
}
