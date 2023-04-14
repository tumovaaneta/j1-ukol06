package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    //    **************************************************************************
    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
//    ******************************************************************************
    private JButton vypocitatButton;
//************************************************************************************

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka Aneta 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));
        //TODO implementovat formulář podle zadání

        husyField = new JTextField();
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar());

        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);
        add(vypocitatButton);


        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav: ");
        pocetHlavLabel.setDisplayedMnemonic('H');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou: ");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHlav;
        int pocetNohou;

        pocetHlav = Integer.parseInt(husyField.getText()) + Integer.parseInt(kraliciField.getText());
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetHlavField.setEditable(false);



        pocetNohou = (Integer.parseInt(husyField.getText()) * 2) + (Integer.parseInt(kraliciField.getText()) * 4);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setText(Integer.toString(pocetNohou));
        pocetNohouField.setEditable(false);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

}
