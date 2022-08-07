package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class APAirlines extends JFrame implements ActionListener {

    JButton b1;

    APAirlines() {
        this.setTitle("AP Airlines");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(940, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        JPanel p2 = new JPanel();
        JPanel footer = new JPanel();
        JPanel aboutus = new JPanel();
        JPanel services = new JPanel();
        JPanel l = new JPanel();
        JPanel r = new JPanel();

        header.setPreferredSize(new Dimension(0, 100));
        footer.setPreferredSize(new Dimension(0, 40));
        aboutus.setPreferredSize(new Dimension(0, 160));
        aboutus.setVisible(true);
        l.setPreferredSize(new Dimension(40, 0));
        r.setPreferredSize(new Dimension(40, 0));

        p2.setLayout(new BorderLayout());
        p2.add(aboutus, BorderLayout.NORTH);
        p2.add(services, BorderLayout.CENTER);

        JLabel label = new JLabel();
        label.setText("AP Airlines");
        label.setFont(new Font("Magneto", Font.BOLD, 48));
        label.setForeground(Color.red);
        header.add(label);

        TitledBorder tb1 = new TitledBorder("About Us");
        tb1.setTitleFont(new Font("Verdana", Font.BOLD, 16));
        aboutus.setBorder(tb1);
        aboutus.setLayout(null);

        JLabel l1 = new JLabel();
        l1.setText("<html>&emsp;Our mission is to offer low fares to enable more people to fly to more places, more often. " +
                "Since<br> we launched in India in 2020, we’ve carried more than 1 million passengers.</html>");
        l1.setBounds(30, 15, 900, 80);
        l1.setFont(new Font("Verdana", Font.PLAIN, 16));


        b1 = new JButton("Proceed to Ticket Booking");
        b1.setBounds(270, 100, 300, 23);
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));

        aboutus.add(l1);
        aboutus.add(b1);

        TitledBorder tb2 = new TitledBorder("Services");
        tb2.setTitleFont(new Font("Verdana", Font.BOLD, 18));
        services.setBorder(tb2);
        services.setLayout(null);

        JLabel l2 = new JLabel();
        l2.setText("<html>&emsp;Our fleets are continuously providing services 24 * 7 among following cities-<br><br>" +
                "<u>Domestic</u>: Delhi, Mumbai, Chennai, Kolkata, Pune, Amritsar, Hyderabad, Bangalore, Kochi, <br>Trivandrum, Patna, Ranchi, Guwahati.<br><br>" +
                "<u>International</u>: New York, London, Mexico, Sydney, Wellington, Tokyo, Paris, Beijing, <br>Abu Dhabi, Seoul, Berlin.</html>");
        l2.setBounds(30, 40, 900, 150);
        l2.setFont(new Font("Verdana", Font.PLAIN, 16));
        services.add(l2);

        footer.setLayout(null);
        JLabel l4 = new JLabel("Contact us: info@ap-airlines.com");
        l4.setFont(new Font("Verdana", Font.PLAIN, 12));
        l4.setBounds(670, 10, 300, 20);

        footer.add(l4);

        this.add(header, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.add(l, BorderLayout.EAST);
        this.add(r, BorderLayout.WEST);
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new BookTicket();
        }
    }
}

class BookTicket extends JFrame implements ActionListener {
    JComboBox year, month, day, cmb4, cmb5, cmb6, cmb7, cmb8, cmb9, cmb10, cmb11;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18;
    JRadioButton rb1, rb2, rb3, rb4;
    JCheckBox cb1, cb2, cb3;
    JButton b1, b3, b4, b2;
    ButtonGroup bg1, bg2, bg3;
    JLabel price;
    String[] dcity = {"DEL", "BOM", "MAA", "CCU", "PNQ", "ATQ", "HYD", "BLR", "COK", "TRV", "PAT", "IXR", "GAU"};
    String[] icity = {"NYC", "LON", "MEX", "SYD", "WLG", "TYO", "PAR", "BJS", "AUH", "SEL", "BER"};
    JPanel flightDetails, passengerDetails;
    double fare = 0;

    BookTicket() {
        JPanel header = new JPanel();
        JPanel p2 = new JPanel();
        JPanel footer = new JPanel();
        flightDetails = new JPanel();
        passengerDetails = new JPanel();
        JPanel l = new JPanel();
        JPanel r = new JPanel();

        header.setPreferredSize(new Dimension(0, 50));
        footer.setPreferredSize(new Dimension(0, 90));
        flightDetails.setPreferredSize(new Dimension(0, 160));
        flightDetails.setVisible(true);
        l.setPreferredSize(new Dimension(20, 0));
        r.setPreferredSize(new Dimension(20, 0));

        p2.setLayout(new BorderLayout());
        p2.add(flightDetails, BorderLayout.NORTH);
        p2.add(passengerDetails, BorderLayout.CENTER);

        JLabel label = new JLabel();
        label.setText("Airline Reservation System");
        label.setFont(new Font("Verdana", Font.BOLD, 24));
        header.add(label);

        TitledBorder tb = new TitledBorder("Flight Details");
        tb.setTitleFont(new Font("Verdana", Font.BOLD, 14));
        flightDetails.setBorder(tb);
        flightDetails.setLayout(null);

        JLabel date = new JLabel("Journey Date");
        date.setFont(new Font("Verdana", Font.PLAIN, 14));
        date.setBounds(20, 30, 100, 18);

        year = new JComboBox();
        year.setBounds(130, 30, 60, 23);
        year.setFont(new Font("Verdana", Font.PLAIN, 12));
        for (int i = 2022; i <= 2030; i++) {
            year.addItem(i);
        }
        year.addActionListener(this);
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        month = new JComboBox(months);
        month.setBounds(195, 30, 60, 23);
        month.setFont(new Font("Verdana", Font.PLAIN, 12));
        month.addActionListener(this);
        day = new JComboBox();
        day.setEnabled(false);
        day.setBounds(260, 30, 50, 23);
        day.setFont(new Font("Verdana", Font.PLAIN, 12));

        JLabel from = new JLabel("From");
        from.setFont(new Font("Verdana", Font.PLAIN, 14));
        from.setBounds(350, 30, 40, 18);

        cmb4 = new JComboBox(dcity);
        cmb4.setBounds(400, 30, 80, 23);
        cmb4.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb4.addActionListener(this);

        JLabel to = new JLabel("To");
        to.setFont(new Font("Verdana", Font.PLAIN, 14));
        to.setBounds(500, 30, 20, 18);

        cmb5 = new JComboBox();
        cmb5.setBounds(530, 30, 80, 23);
        cmb5.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb5.setEnabled(false);

        rb1 = new JRadioButton("Domestic");
        rb1.setFont(new Font("Verdana", Font.PLAIN, 14));
        rb1.setBounds(650, 30, 100, 23);
        rb1.setSelected(true);
        rb1.addActionListener(this);

        rb2 = new JRadioButton("International");
        rb2.setFont(new Font("Verdana", Font.PLAIN, 14));
        rb2.setBounds(755, 30, 120, 23);
        rb2.addActionListener(this);

        bg1 = new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        JLabel time = new JLabel("Departure Time");
        time.setFont(new Font("Verdana", Font.PLAIN, 14));
        time.setBounds(20, 70, 120, 18);

        cmb6 = new JComboBox();
        cmb6.setBounds(150, 70, 80, 23);
        cmb6.setFont(new Font("Verdana", Font.PLAIN, 12));
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j += 15) {
                if (i <= 9 && j <= 9)
                    cmb6.addItem("0" + i + ":0" + j);
                else if (i > 9 && j <= 9)
                    cmb6.addItem(i + ":0" + j);
                else if (i <= 9 && j > 9)
                    cmb6.addItem("0" + i + ":" + j);
                else
                    cmb6.addItem(i + ":" + j);
            }
        }

        JLabel fno = new JLabel("Flight Number");
        fno.setFont(new Font("Verdana", Font.PLAIN, 14));
        fno.setBounds(350, 70, 110, 18);

        t1 = new JTextField();
        t1.setBounds(470, 70, 130, 23);

        rb3 = new JRadioButton("Economy");
        rb3.setFont(new Font("Verdana", Font.PLAIN, 14));
        rb3.setBounds(650, 70, 100, 23);

        rb4 = new JRadioButton("Business");
        rb4.setFont(new Font("Verdana", Font.PLAIN, 14));
        rb4.setBounds(755, 70, 120, 23);

        bg2 = new ButtonGroup();
        bg2.add(rb3);
        bg2.add(rb4);

        price = new JLabel("");
        price.setFont(new Font("Verdana", Font.PLAIN, 14));
        price.setForeground(Color.BLUE);
        price.setBounds(330, 120, 300, 16);

        b1 = new JButton("Reset");
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBounds(650, 120, 80, 23);

        b2 = new JButton("Confirm");
        b2.setFont(new Font("Verdana", Font.PLAIN, 14));
        b2.setBounds(770, 120, 100, 23);

        flightDetails.add(date);
        flightDetails.add(year);
        flightDetails.add(month);
        flightDetails.add(day);
        flightDetails.add(from);
        flightDetails.add(to);
        flightDetails.add(cmb4);
        flightDetails.add(cmb5);
        flightDetails.add(rb1);
        flightDetails.add(rb2);
        flightDetails.add(time);
        flightDetails.add(cmb6);
        flightDetails.add(fno);
        flightDetails.add(t1);
        flightDetails.add(rb3);
        flightDetails.add(rb4);
        flightDetails.add(price);
        flightDetails.add(b1);
        flightDetails.add(b2);

        TitledBorder tb1 = new TitledBorder("Passenger Details");
        tb1.setTitleFont(new Font("Verdana", Font.BOLD, 14));
        passengerDetails.setBorder(tb1);
        passengerDetails.setLayout(null);

        JLabel adults = new JLabel("No. of adult");
        adults.setFont(new Font("Verdana", Font.PLAIN, 14));
        adults.setBounds(20, 30, 90, 18);

        t2 = new JTextField();
        t2.setBounds(115, 30, 20, 23);
        t2.setText("1");

        JLabel child = new JLabel("No. of child");
        child.setFont(new Font("Verdana", Font.PLAIN, 14));
        child.setBounds(170, 30, 90, 18);

        t3 = new JTextField();
        t3.setBounds(260, 30, 20, 23);
        t3.setText("0");

        cb1 = new JCheckBox("Opt for meal");
        cb1.setFont(new Font("Verdana", Font.PLAIN, 14));
        cb1.setBounds(500, 30, 150, 23);
        cb1.addActionListener(this);

        cb2 = new JCheckBox("VEG");
        cb2.setFont(new Font("Verdana", Font.PLAIN, 14));
        cb2.setBounds(650, 30, 100, 23);
        cb2.setSelected(true);
        cb2.setVisible(false);

        cb3 = new JCheckBox("NON-VEG");
        cb3.setFont(new Font("Verdana", Font.PLAIN, 14));
        cb3.setBounds(750, 30, 100, 23);
        cb3.setVisible(false);

        bg3 = new ButtonGroup();
        bg3.add(cb2);
        bg3.add(cb3);

        JLabel first = new JLabel("First Name");
        first.setFont(new Font("Verdana", Font.PLAIN, 14));
        first.setBounds(165, 75, 90, 18);

        JLabel last = new JLabel("Last Name");
        last.setFont(new Font("Verdana", Font.PLAIN, 14));
        last.setBounds(400, 75, 90, 18);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Verdana", Font.PLAIN, 14));
        age.setBounds(590, 75, 90, 18);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Verdana", Font.PLAIN, 14));
        gender.setBounds(700, 75, 90, 18);

        String[] gen = {"Male", "Female", "Others"};

        t4 = new JTextField();
        t4.setBounds(120, 100, 170, 23);

        t5 = new JTextField();
        t5.setBounds(350, 100, 170, 23);

        t6 = new JTextField();
        t6.setBounds(580, 100, 50, 23);

        cmb7 = new JComboBox(gen);
        cmb7.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb7.setBounds(690, 100, 80, 23);


        t7 = new JTextField();
        t7.setBounds(120, 130, 170, 23);

        t8 = new JTextField();
        t8.setBounds(350, 130, 170, 23);

        t9 = new JTextField();
        t9.setBounds(580, 130, 50, 23);

        cmb8 = new JComboBox(gen);
        cmb8.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb8.setBounds(690, 130, 80, 23);


        t10 = new JTextField();
        t10.setBounds(120, 160, 170, 23);

        t11 = new JTextField();
        t11.setBounds(350, 160, 170, 23);

        t12 = new JTextField();
        t12.setBounds(580, 160, 50, 23);

        cmb9 = new JComboBox(gen);
        cmb9.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb9.setBounds(690, 160, 80, 23);


        t13 = new JTextField();
        t13.setBounds(120, 190, 170, 23);

        t14 = new JTextField();
        t14.setBounds(350, 190, 170, 23);

        t15 = new JTextField();
        t15.setBounds(580, 190, 50, 23);

        cmb10 = new JComboBox(gen);
        cmb10.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb10.setBounds(690, 190, 80, 23);


        t16 = new JTextField();
        t16.setBounds(120, 220, 170, 23);

        t17 = new JTextField();
        t17.setBounds(350, 220, 170, 23);

        t18 = new JTextField();
        t18.setBounds(580, 220, 50, 23);

        cmb11 = new JComboBox(gen);
        cmb11.setFont(new Font("Verdana", Font.PLAIN, 12));
        cmb11.setBounds(690, 220, 80, 23);

        b3 = new JButton("Reset");
        b3.setFont(new Font("Verdana", Font.PLAIN, 14));
        b3.setBounds(650, 270, 80, 23);

        b4 = new JButton("Book Ticket");
        b4.setFont(new Font("Verdana", Font.PLAIN, 14));
        b4.setBounds(750, 270, 120, 23);

        t2.setEnabled(false);
        t3.setEnabled(false);
        cb1.setEnabled(false);
        cb2.setVisible(false);
        cb3.setVisible(false);
        t4.setEnabled(false);
        t5.setEnabled(false);
        t6.setEnabled(false);
        cmb7.setEnabled(false);
        t7.setEnabled(false);
        t8.setEnabled(false);
        t9.setEnabled(false);
        cmb8.setEnabled(false);
        t10.setEnabled(false);
        t11.setEnabled(false);
        t12.setEnabled(false);
        cmb9.setEnabled(false);
        t13.setEnabled(false);
        t14.setEnabled(false);
        t15.setEnabled(false);
        cmb10.setEnabled(false);
        t16.setEnabled(false);
        t17.setEnabled(false);
        t18.setEnabled(false);
        cmb11.setEnabled(false);

        passengerDetails.add(adults);
        passengerDetails.add(t2);
        passengerDetails.add(child);
        passengerDetails.add(t3);
        passengerDetails.add(cb1);
        passengerDetails.add(cb2);
        passengerDetails.add(cb3);
        passengerDetails.add(first);
        passengerDetails.add(last);
        passengerDetails.add(age);
        passengerDetails.add(gender);
        passengerDetails.add(t4);
        passengerDetails.add(t5);
        passengerDetails.add(t6);
        passengerDetails.add(cmb7);
        passengerDetails.add(t7);
        passengerDetails.add(t8);
        passengerDetails.add(t9);
        passengerDetails.add(cmb8);
        passengerDetails.add(t10);
        passengerDetails.add(t11);
        passengerDetails.add(t12);
        passengerDetails.add(cmb9);
        passengerDetails.add(t13);
        passengerDetails.add(t14);
        passengerDetails.add(t15);
        passengerDetails.add(cmb10);
        passengerDetails.add(t16);
        passengerDetails.add(t17);
        passengerDetails.add(t18);
        passengerDetails.add(cmb11);
        passengerDetails.add(b3);
        passengerDetails.add(b4);

        TitledBorder tb3 = new TitledBorder("Instructions");
        tb3.setTitleFont(new Font("Verdana", Font.BOLD, 14));
        tb3.setTitleColor(Color.red);
        footer.setBorder(tb3);
        footer.setLayout(null);

        JLabel one = new JLabel();
        one.setText("1. Booking is allowed for maximum 5 (five) passengers including children per ticket.");
        one.setFont(new Font("Verdana", Font.PLAIN, 14));
        one.setBounds(20, 20, 940, 18);

        JLabel second = new JLabel();
        second.setText("2. Full charge will be applicable for child more than 2 years age.");
        second.setFont(new Font("Verdana", Font.PLAIN, 14));
        second.setBounds(20, 40, 940, 18);

        JLabel third = new JLabel();
        third.setText("3. All fields are mandatory.");
        third.setFont(new Font("Verdana", Font.PLAIN, 14));
        third.setBounds(20, 60, 940, 18);

        footer.add(one);
        footer.add(second);
        footer.add(third);

        this.setTitle("AP Airlines - Booking Process");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(940, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(header, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        this.add(l, BorderLayout.EAST);
        this.add(r, BorderLayout.WEST);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == year || e.getSource() == month) {
            day.setEnabled(true);
            int s = (int) year.getSelectedItem();
            int s1 = 1 + month.getSelectedIndex();

            if (s1 == 1 || s1 == 3 || s1 == 5 || s1 == 7 || s1 == 8 || s1 == 10 || s1 == 12) {
                day.removeAllItems();
                for (int i = 1; i <= 31; i++) {
                    if (i < 10)
                        day.addItem("0" + i);
                    else
                        day.addItem(i);
                }
            }
            if (s1 == 4 || s1 == 6 || s1 == 9 || s1 == 11) {
                day.removeAllItems();
                for (int i = 1; i <= 30; i++) {
                    if (i < 10)
                        day.addItem("0" + i);
                    else
                        day.addItem(i);
                }
            }

            if ((s % 4 == 0 && s % 100 != 0) || s % 400 == 0) {
                //leap year
                if (s1 == 2) {
                    day.removeAllItems();
                    for (int i = 1; i <= 29; i++) {
                        if (i < 10)
                            day.addItem("0" + i);
                        else
                            day.addItem(i);
                    }
                }

            } else {
                if (s1 == 2) {
                    day.removeAllItems();
                    for (int i = 1; i <= 28; i++) {
                        if (i < 10)
                            day.addItem("0" + i);
                        else
                            day.addItem(i);
                    }
                }
            }
        }

        if (e.getSource() == b1) {
            year.setEnabled(true);
            month.setEnabled(true);
            cmb4.setEnabled(true);
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);
            t1.setEnabled(true);
            cmb6.setEnabled(true);
            year.setSelectedIndex(0);
            month.setSelectedIndex(0);
            day.removeAllItems();
            day.setEnabled(false);
            cmb4.setSelectedIndex(0);
            cmb5.removeAllItems();
            cmb5.setEnabled(false);
            bg1.clearSelection();
            rb1.setSelected(true);
            bg2.clearSelection();
            cmb6.setSelectedIndex(0);
            t1.setText("");
            //passengers
            t2.setEnabled(false);
            t3.setEnabled(false);
            cb1.setEnabled(false);
            cb2.setVisible(false);
            cb3.setVisible(false);
            t4.setEnabled(false);
            t5.setEnabled(false);
            t6.setEnabled(false);
            cmb7.setEnabled(false);
            t7.setEnabled(false);
            t8.setEnabled(false);
            t9.setEnabled(false);
            cmb8.setEnabled(false);
            t10.setEnabled(false);
            t11.setEnabled(false);
            t12.setEnabled(false);
            cmb9.setEnabled(false);
            t13.setEnabled(false);
            t14.setEnabled(false);
            t15.setEnabled(false);
            cmb10.setEnabled(false);
            t16.setEnabled(false);
            t17.setEnabled(false);
            t18.setEnabled(false);
            cmb11.setEnabled(false);
        }

        if (e.getSource() == rb1) {
            cmb4.removeAllItems();
            for (int i = 0; i < dcity.length; i++)
                cmb4.addItem(dcity[i]);
        }

        if (e.getSource() == rb2) {
            cmb4.removeAllItems();
            for (int i = 0; i < dcity.length; i++)
                cmb4.addItem(dcity[i]);
            for (int i = 0; i < icity.length; i++)
                cmb4.addItem(icity[i]);
        }

        if (e.getSource() == cmb4) {
            String temp = (String) cmb4.getSelectedItem();
            cmb5.setEnabled(true);
            cmb5.removeAllItems();
            if (rb1.isSelected()) {
                for (int i = 0; i < dcity.length; i++) {
                    if (temp == dcity[i])
                        continue;
                    cmb5.addItem(dcity[i]);
                }
            }

            if (rb2.isSelected()) {
                int flag = 0;
                for (int i = 0; i < dcity.length; i++) {
                    if (temp == dcity[i]) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 1) {
                    for (int i = 0; i < icity.length; i++)
                        cmb5.addItem(icity[i]);
                } else {
                    for (int i = 0; i < dcity.length; i++)
                        cmb5.addItem(dcity[i]);
                    for (int i = 0; i < icity.length; i++) {
                        if (temp == icity[i])
                            continue;
                        cmb5.addItem(icity[i]);
                    }
                }
            }
        }

        if (e.getSource() == b2) {
            if (rb1.isSelected())
                fare = 6275.0;
            if (rb2.isSelected())
                fare = 37625.0;

            if (rb3.isSelected())
                fare += 0;
            if (rb1.isSelected() && rb4.isSelected())
                fare += 2357;
            if (rb2.isSelected() && rb4.isSelected())
                fare += 10348;

            if (day.getSelectedItem() == null || cmb5.getSelectedItem() == null || t1.getText().trim().equals("") || (rb3.isSelected() == false && rb4.isSelected() == false)) {
                JLabel label = new JLabel("All fields are mandatory");
                label.setFont(new Font("Verdana", Font.PLAIN, 12));
                JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
            } else {
                String s = t1.getText();
                if (s.length() == 6 && s.substring(0, 3).equals("APF")) {
                    try {
                        int i = Integer.parseInt(s.substring(3, 6));

                        price.setText("Rs. " + fare + "/- per person");
                        year.setEnabled(false);
                        month.setEnabled(false);
                        day.setEnabled(false);
                        cmb4.setEnabled(false);
                        cmb5.setEnabled(false);
                        rb1.setEnabled(false);
                        rb2.setEnabled(false);
                        rb3.setEnabled(false);
                        rb4.setEnabled(false);
                        t1.setEnabled(false);
                        cmb6.setEnabled(false);
                        //passengers
                        t2.setEnabled(true);
                        t3.setEnabled(true);
                        cb1.setEnabled(true);
                        cb2.setVisible(false);
                        cb3.setVisible(false);
                        t4.setEnabled(true);
                        t5.setEnabled(true);
                        t6.setEnabled(true);
                        cmb7.setEnabled(true);
                        t7.setEnabled(true);
                        t8.setEnabled(true);
                        t9.setEnabled(true);
                        cmb8.setEnabled(true);
                        t10.setEnabled(true);
                        t11.setEnabled(true);
                        t12.setEnabled(true);
                        cmb9.setEnabled(true);
                        t13.setEnabled(true);
                        t14.setEnabled(true);
                        t15.setEnabled(true);
                        cmb10.setEnabled(true);
                        t16.setEnabled(true);
                        t17.setEnabled(true);
                        t18.setEnabled(true);
                        cmb11.setEnabled(true);
                    } catch (Exception ex) {
                        JLabel label = new JLabel("Invalid Flight Number!! Should be of form APF123");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JLabel label = new JLabel("Invalid Flight Number!! Should be of form APF123");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == b3) {
            t2.setText("1");
            t3.setText("0");
            cb1.setSelected(false);
            cb2.setVisible(false);
            cb3.setVisible(false);
            t4.setText("");
            t5.setText("");
            t6.setText("");
            cmb7.setSelectedIndex(0);
            t7.setText("");
            t8.setText("");
            t9.setText("");
            cmb8.setSelectedIndex(0);
            t10.setText("");
            t11.setText("");
            t12.setText("");
            cmb9.setSelectedIndex(0);
            t13.setText("");
            t14.setText("");
            t15.setText("");
            cmb10.setSelectedIndex(0);
            t16.setText("");
            t17.setText("");
            t18.setText("");
            cmb11.setSelectedIndex(0);

        }

        if (e.getSource() == b4) {
            double fare2 = 0,flg=0;
            try {
                int i1 = Integer.parseInt(t2.getText());
                int i2 = Integer.parseInt(t3.getText());
                flg=1;
                if (cb1.isSelected()) {
                    if (cb2.isSelected())
                        fare2 = 500;
                    if (cb3.isSelected())
                        fare2 = 1000;
                }

                int noOfAdultPassenger = 0, noOfChildPassenger = 0;
                int cnt = 0, ageMatch = 0;

                if (!t4.getText().trim().isEmpty())
                    cnt++;
                if (!t5.getText().trim().isEmpty())
                    cnt++;

                if (!t6.getText().trim().isEmpty()) {
                    cnt++;
                    if (Integer.parseInt(t6.getText()) < 0 || Integer.parseInt(t6.getText()) > 100)
                    {
                        JLabel label = new JLabel("Age should be between 0 and 100.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                        t6.setText("");
                    }
                    if (Integer.parseInt(t6.getText()) <= 2)
                        ageMatch++;
                }

                if (!t7.getText().trim().isEmpty())
                    cnt++;
                if (!t8.getText().trim().isEmpty())
                    cnt++;
                if (!t9.getText().trim().isEmpty()) {
                    cnt++;
                    if (Integer.parseInt(t9.getText()) < 0 || Integer.parseInt(t9.getText()) > 100)
                    {
                        JLabel label = new JLabel("Age should be between 0 and 100.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                        t9.setText("");
                    }
                    if (Integer.parseInt(t9.getText()) <= 2)
                        ageMatch++;
                }

                if (!t10.getText().trim().isEmpty())
                    cnt++;
                if (!t11.getText().trim().isEmpty())
                    cnt++;
                if (!t12.getText().trim().isEmpty()) {
                    cnt++;
                    if (Integer.parseInt(t12.getText()) < 0 || Integer.parseInt(t12.getText()) > 100)
                    {
                        JLabel label = new JLabel("Age should be between 0 and 100.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                        t12.setText("");
                    }
                    if (Integer.parseInt(t12.getText()) <= 2)
                        ageMatch++;
                }

                if (!t13.getText().trim().isEmpty())
                    cnt++;
                if (!t14.getText().trim().isEmpty())
                    cnt++;
                if (!t15.getText().trim().isEmpty()) {
                    cnt++;
                    if (Integer.parseInt(t15.getText()) < 0 || Integer.parseInt(t15.getText()) > 100)
                    {
                        JLabel label = new JLabel("Age should be between 0 and 100.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                        t15.setText("");
                    }
                    if (Integer.parseInt(t15.getText()) <= 2)
                        ageMatch++;
                }

                if (!t16.getText().trim().isEmpty())
                    cnt++;
                if (!t17.getText().trim().isEmpty())
                    cnt++;
                if (!t18.getText().trim().isEmpty()) {
                    cnt++;
                    if (Integer.parseInt(t18.getText()) < 0 || Integer.parseInt(t18.getText()) > 100)
                    {
                        JLabel label = new JLabel("Age should be between 0 and 100.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                        t18.setText("");
                    }
                    if (Integer.parseInt(t18.getText()) <= 2)
                        ageMatch++;
                }
                int flag = 0;
                if (t2.getText().trim().equals("") || t3.getText().trim().equals("")) {
                    JLabel label = new JLabel("Mandatory fields are empty.");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.WARNING_MESSAGE);
                    flag = 1;
                } else if (!t2.getText().trim().isEmpty() && !t3.getText().trim().isEmpty()) {
                    noOfAdultPassenger = Integer.parseInt(t2.getText());
                    noOfChildPassenger = Integer.parseInt(t3.getText());
                }

                if ((noOfAdultPassenger + noOfChildPassenger) > 5) {
                    JLabel label = new JLabel("Number of passengers should not exceed 5");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                } else if (cnt == 3 * (noOfAdultPassenger + noOfChildPassenger) && ageMatch == noOfChildPassenger) {
                    if (flag == 1) {
                    } else if (noOfAdultPassenger == 0) {
                        JLabel label = new JLabel("There must be an adult in the journey.");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double fare3 = (fare + fare2) * noOfAdultPassenger;
                        double fare4 = 0.5 * (fare + fare2) * noOfChildPassenger;
                        JLabel label = new JLabel("<html>Ticket Booked Successfully<br>Amount to be paid: Rs " + (fare3 + fare4) + "</html>");
                        label.setFont(new Font("Verdana", Font.PLAIN, 12));
                        //bookTicket
                        JOptionPane.showMessageDialog(null, label, "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else if (ageMatch != noOfChildPassenger) {
                    JLabel label = new JLabel("Age is entered incorrectly.");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    //AgeWronglySpecified
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                }
                else if(cnt==0 && (noOfAdultPassenger + noOfChildPassenger)!=0)
                {
                    JLabel label = new JLabel("Passenger details can't be empty.");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                }
                else if (cnt != 3 * (noOfAdultPassenger + noOfChildPassenger)) {
                    JLabel label = new JLabel("Passenger details are wrong.");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    //passengerMismatch
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception ex) {
                if(flg==0)
                {
                    JLabel label = new JLabel("No of adults/No of child is invalid");
                    label.setFont(new Font("Verdana", Font.PLAIN, 12));
                    JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);
                }
                JLabel label = new JLabel("Age is invalid!");
                label.setFont(new Font("Verdana", Font.PLAIN, 12));
                JOptionPane.showMessageDialog(null, label, "Fail", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == cb1) {
            if (cb1.isSelected()) {
                cb2.setVisible(true);
                cb3.setVisible(true);
            }
            if (!cb1.isSelected()) {
                cb2.setVisible(false);
                cb3.setVisible(false);
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
        new APAirlines();
    }
}