import javafx.scene.chart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {

    private JButton btnAfsluiten  = new JButton("Afsluiten");
    private JButton btnMenu = new JButton("Ga terug");

    private JButton btnSeries = new JButton("Series");
    private JButton btnZoekSerie = new JButton("Zoek");
    private JButton btnFilms = new JButton("Films");
    private JButton btnAbbonnees = new JButton("Abbonnees");
    private JButton btnProfielen = new JButton("Profielen");



    //private JButton btnAlle

    private JButton btnSerieAccount = new JButton ("Filter ook op account (nr.)");



    private JTextField txtA = new JTextField();
    private JTextField txtB = new JTextField();
    private JTextArea txtC = new JTextArea();

    private JTextField acc = new JTextField();
    private JTextField naam = new JTextField();
    private JTextField straat = new JTextField();
    private JTextField postcode = new JTextField();
    private JTextField nummer = new JTextField();
    private JTextField woonplaats = new  JTextField();

    private JButton btnMaakAccount = new JButton("Maak Account");
    private JButton btnVoegToe = new JButton("Voeg toe");

    private JLabel lblA = new JLabel("Voer serie in");
    private JLabel lblB = new JLabel("Voer een film in");

    private JLabel maakAccA = new JLabel("Voer hier het 7-cijferige accountnummer, een naam, en straat in. Vul alle velden in!");
    private JLabel maakAccB = new JLabel("Voer hier de postcode, het huisnummer, en de woonplaats in. Vul alle velden in!");
    //private JLabel lblC = new JLabel("C :");

    public static String input;
    public static String sAcc;
    public static String sNaam;
    public static String sStraat;
    public static String sPostcode;
    public static String sNummer;
    public static String sWoonplaats;

    public MyFrame(){
        setTitle("NetFlix Statistix");
        setSize(1200,750);
        setLocation(new Point(300,200));
        setLayout(null);
        setResizable(true);

        initComponent();
        initEvent();
    }

    private void initComponent(){
        btnAfsluiten.setBounds(1050,5, 130,25);
        btnMenu.setBounds(910, 5, 130, 25);
        btnMenu.setVisible(false);

        btnSeries.setBounds(20,10,120,25);
        btnZoekSerie.setBounds(130,40,100,20);
        btnFilms.setBounds(20, 40,120,25);
        btnAbbonnees.setBounds(20,70, 120, 25);
        btnProfielen.setBounds(20,100,120,25);

       btnMaakAccount.setBounds(20,160,120,25);
       btnVoegToe.setBounds(665,110,120,25);
       btnVoegToe.setVisible(false);





        txtA.setBounds(130,10,100,20);
        txtA.setVisible(false);
        txtB.setBounds(100,35,100,20);

        acc.setBounds(200, 50, 150,20);
        acc.setVisible(false);
        naam.setBounds(355,50,150,20);
        naam.setVisible(false);
        straat.setBounds(510,50,150,20);
        straat.setVisible(false);
        postcode.setBounds(200,110,150,20);
        postcode.setVisible(false);
        nummer.setBounds(355,110,150,20);
        nummer.setVisible(false);
        woonplaats.setBounds(510,110,150,20);
        woonplaats.setVisible(false);

        maakAccA.setBounds(200,20, 500,20);
        maakAccA.setVisible(false);
        maakAccB.setBounds(200,80,500,20);
        maakAccB.setVisible(false);

        txtC.setBounds(200,150,1000,500);
        txtC.setEditable(false);
        txtC.setFont(new Font("monospaced", Font.PLAIN, 15));

        lblA.setBounds(20,10,100,20);
        lblB.setBounds(20,10,100,20);
        lblB.setVisible(false);
        lblA.setVisible(false);

        add(maakAccA);
        add(maakAccB);

        add(btnAfsluiten);
        add(btnMenu);
        add(btnMaakAccount);
        add(btnVoegToe);

        add(btnSeries);
        add(btnZoekSerie);
        btnZoekSerie.setVisible(false);

        add(btnAbbonnees);

        add(btnProfielen);

        add(btnFilms);

        add(acc);
        add(naam);
        add(straat);
        add(postcode);
        add(nummer);
        add(woonplaats);

        add(lblA);
        //add(lblB);
        //add(lblC);

        add(txtA);
       // add(txtB);
        add(txtC);




    }

    private void initEvent(){

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });

        btnAfsluiten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAflsuiten(e);
            }
        });

        btnSeries.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSeries(e);
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnMenu(e); }
        });
        btnZoekSerie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnZoekSerie(e); }
        });
        btnFilms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnFilms(e); }
        });
        btnProfielen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnProfielen(e); }
        });
        btnAbbonnees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnAbbonnees(e); }
        });
        btnMaakAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnMaakAccount(e); }
        });
        btnVoegToe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { btnVoegToe(e); }
        });

    }

    private void btnAflsuiten(ActionEvent evt){
        System.exit(0);
    }

    private void btnProfielen(ActionEvent evt){
        Profielen Profiel = new Profielen();
        txtC.setText(Profiel.Profielen());
    }

    private void btnMaakAccount(ActionEvent evt){
        btnSeries.setVisible(false);
        btnFilms.setVisible(false);
        btnAbbonnees.setVisible(false);
        btnProfielen.setVisible(false);
        btnMaakAccount.setVisible(false);

        btnMenu.setVisible(true);

        btnVoegToe.setVisible(true);
        acc.setVisible(true);
        naam.setVisible(true);
        straat.setVisible(true);
        postcode.setVisible(true);
        nummer.setVisible(true);
        woonplaats.setVisible(true);
        maakAccB.setVisible(true);
        maakAccA.setVisible(true);
    }

    private void btnSeries(ActionEvent evt){

        btnMenu.setVisible(true);
        btnZoekSerie.setVisible(true);
        txtA.setVisible(true);
        lblA.setText("Voer een serie in");


        btnSeries.setVisible(false);
        btnFilms.setVisible(false);
        btnAbbonnees.setVisible(false);
        btnProfielen.setVisible(false);

        Series serie = new Series();
        txtC.setText(serie.alleSeries());




        String x,y,z;

        try{
            x = txtA.getText();
        //    y = Integer.parseInt(txtB.getText());
           // z = x + y;
            //txtC.setText(z.toString());

        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    e.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(txtA.getText());

    }

    private void btnMenu(ActionEvent evt){
        btnSeries.setVisible(true);
        btnFilms.setVisible(true);
        btnAbbonnees.setVisible(true);
        btnProfielen.setVisible(true);
        btnMaakAccount.setVisible(true);

        btnMenu.setVisible(false);
        txtA.setVisible(false);
        btnZoekSerie.setVisible(false);
        txtB.setVisible(false);

        acc.setVisible(false);
        naam.setVisible(false);
        straat.setVisible(false);
        postcode.setVisible(false);
        nummer.setVisible(false);
        woonplaats.setVisible(false);
        maakAccB.setVisible(false);
        maakAccA.setVisible(false);

        btnVoegToe.setVisible(false);
    }



    private void btnZoekSerie(ActionEvent evt){
        setInput(txtA.getText());
        Series serie = new Series();
        txtC.setText(serie.getSerie());
    }
    private void btnFilms (ActionEvent evt){
        Film film = new Film();
        txtC.setText(film.alleFilms());





    }
    private void btnAbbonnees(ActionEvent evt){
        Abonnees abbonee = new Abonnees();
        txtC.setText(abbonee.getAbonnees());
    }
    private void btnVoegToe(ActionEvent evt){
        setAcc(acc.getText());
        setNaam(naam.getText());
        setStraat(straat.getText());
        setPostcode(postcode.getText());
        setNummer(nummer.getText());
        setWoonplaats(woonplaats.getText());


        CRUD crud = new CRUD();

    }

    public void setInput(String input){
        this.input = input;
    }
    public String getInput(){
        return input;
    }

    public void setAcc(String sAcc){
        this.sAcc = sAcc;
    }
    public String getAcc(){
        return sAcc;
    }
    public void setNaam (String sNaam){
        this.sNaam = sNaam;
    }
    public String getNaam(){
        return sNaam;
    }
    public void setStraat (String sStraat){
        this.sStraat = sStraat;
    }
    public String getStraat(){
        return sStraat;
    }
    public void setPostcode (String sPostcode){
        this.sPostcode = sPostcode;
    }
    public String getPostcode(){
        return sPostcode;
    }
    public void setNummer (String sNummer){
        this.sNummer = sNummer;
    }
    public String getNummer(){
        return sNummer;
    }
    public void setWoonplaats (String sWoonplaats){
        this.sWoonplaats = sWoonplaats;
    }
    public String getWoonplaats(){
        return sWoonplaats;
    }




    }


