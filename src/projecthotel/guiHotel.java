/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projecthotel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;
import javax.swing.text.html.CSS;
import packageHotel.Room;

import packageHotel.Hotel;
import packageHotel.Pemesanan;
import packageHotel.Tamu;

/**
 *
 * @author github.com/Reza1290/gui-hotel-reservation
 */
public class guiHotel extends javax.swing.JFrame {

    private final Hotel hotel; // Sekali Define Tidak dapat diubah! sekali assign
    private List<String> filterType; // awalnya kosong ["Twin"]

    /**
     * Creates new form guiHotel
     */
    public guiHotel() {
        this.hotel = new Hotel("Hoteru", "Jl. Kenangan Bersamamu");
        this.filterType = new LinkedList<String>();

        initComponents();
        namaLabel.setText("HOTEL " + this.hotel.getNamaHotel());
        jalanLabel.setText(this.hotel.getAlamat());
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        listRoomPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        innerRoomPanel.setLayout(new GridLayout(3, 5, 20, 20));

        Room r1 = new Room(101, "King", 400);
        Room r2 = new Room(102, "Twin", 600);
        Room r3 = new Room(103, "Deluxe", 500);
        Room r4 = new Room(104, "Single", 300);

        Room r5 = new Room(105, "Single", 300);
        Room r6 = new Room(106, "Single", 300);
        Room r7 = new Room(107, "Single", 300);
        Room r8 = new Room(108, "Single", 300);
        Room r9 = new Room(109, "Single", 300);

        System.out.println(this.hotel.tambahKamar(r1));
        System.out.println(this.hotel.tambahKamar(r2));
        System.out.println(this.hotel.tambahKamar(r3));
        System.out.println(this.hotel.tambahKamar(r4));
        System.out.println(this.hotel.tambahKamar(r5));
        System.out.println(this.hotel.tambahKamar(r6));
        System.out.println(this.hotel.tambahKamar(r7));
        System.out.println(this.hotel.tambahKamar(r8));
        System.out.println(this.hotel.tambahKamar(r9));

        Tamu user1 = new Tamu("Budi", "Jl. Karang", "6282400003", "ayam@g.com");
        Tamu user2 = new Tamu("Ari", "Jl. Karang", "6282400003", "ayam@g.com");
        Tamu user3 = new Tamu("Ulki", "Jl. Karang", "6282400003", "ayam@g.com");

//      filterType.add("King");
        System.out.println(filterType);

        this.hotel.pesanKamar(user1, r1, LocalDate.of(2023, Month.SEPTEMBER, 29), LocalDate.of(2023, Month.OCTOBER, 1));
        this.hotel.pesanKamar(user2, r2, LocalDate.of(2023, Month.SEPTEMBER, 29), LocalDate.of(2023, Month.OCTOBER, 1));

        renderList();

    }

    /**
     * Ini adalah Fungsi untuk meRender Komponen ( Looping Component )
     *
     * @param hotel
     */
    private void renderList() {

        for (int i = 0; i < this.hotel.getDaftarKamar().size(); i++) {
            if (this.filterType.contains(this.hotel.getDaftarKamar().get(i).getTipeKamar())) {
                innerRoomPanel.add(new roomPanel(this.hotel.getDaftarKamar().get(i), hotel));
            }
        }
        revalidate();
        repaint();
    }

    /**
     * Fungsi untuk membersihkan rendered List Function to delete rendered List
     *
     * (REFRESH)
     */
    public void deleteList() {
        innerRoomPanel.removeAll();
        revalidate();
        repaint();
    }

    /*    
    /**
     * Class
     * Custom Panel For Container Render
     * Wadah untuk tempat Rendering
     */
    private class roomPanel extends JPanel {

        public roomPanel(Room room, Hotel hotel) {
            super();
            setPreferredSize(new Dimension(200, 200));
            setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
            setLayout(new GridLayout(4, 1));

            JButton setStatus = new JButton();
//            setStatus.setPreferredSize(new Dimension(20,100));

            JLabel noKamar = new JLabel("<html> <h1>No." + room.getNomorKamar() + "</h1></html>", JLabel.CENTER);
            JLabel statusKamar = new JLabel("", JLabel.CENTER);
            JLabel hargaKamar = new JLabel("<html>Price : $ " + room.getHarga()
                    + "/night <br>Tipe : " + room.getTipeKamar() + "</html>", JLabel.CENTER);

            if (room.isStatus()) {
                statusKamar.setText("Booked");
                setStatus.setText("UnBook");
                setStatus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        hotel.removeBookedRoom(room.getNomorKamar());
//                        System.out.println("UnBook" + index);
//                        statusKamar.setText("Ready");
//                        setStatus.setText("Book");
//                        deleteList();
//                        renderList(hotel);
                    }
                });
//                setStatus.doClick();
            } else {
                statusKamar.setText("Ready");
                setStatus.setText("Book");
                setStatus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField firstName = new JTextField();
                        JTextField noTelepon = new JTextField();
                        JTextField email    = new JTextField();
                        JDateChooser dateCheckIn = new JDateChooser();
                        JDateChooser dateCheckOut = new JDateChooser();
                        DateFormat formatDate = new SimpleDateFormat();
                        
                        final JComponent[] inputs = new JComponent[]{
                            new JLabel("First"),
                            firstName,
                            new JLabel("No. Telp"),
                            noTelepon,
                            new JLabel("Email"),
                            email,
                            new JLabel("Tanggal Check In : "),
                            dateCheckIn,
                            new JLabel("Tanggal Check Out : "),
                            dateCheckOut,
                            
                        };          
                        int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            System.out.println("You entered "
                                    + firstName.getText() + ", "
                                    + noTelepon.getText() + ", "
                                    + email.getText() + ", "
                                    + formatDate.format(dateCheckIn.getDate())
                                    
                                    + formatDate.format(dateCheckOut.getDate()));
                        } else {
                            System.out.println("User canceled / closed the dialog, result = " + result);
                        }
                        
                        if(firstName.getText() != null && noTelepon.getText() != null && email.getText() != null && dateCheckIn.getDate() != null && dateCheckOut.getDate() != null){
//                            
//                            Tamu detailTamu = new Tamu(firstName.getText(), "Details Hidden", noTelepon.getText() , email.getText());
//                            Pemesanan  book = new Pemesanan(detailTamu,date1, dateCheckOut.getDate(), room);
//                            hotel.pesanKamar(book);
                            
                            
                        }
                        
//                          String name = JOptionPane.showInputDialog("What is your name?");
//                          JOptionPane.showMessageDialog(getParent(), "Hello " + name + '!');
//                        hotel.pesanKamar(index);
//                                                System.out.println("Book" + index);
//
//                        
//                        statusKamar.setText("Booked");
//                        setStatus.setText("UnBook");
//                        deleteList();
//                        renderList(hotel);
                    }
                });
            }

            add(noKamar);
            add(statusKamar);
            add(hargaKamar);
            add(setStatus);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listRoomPanel = new javax.swing.JPanel();
        innerRoomPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        jalanLabel = new javax.swing.JLabel();
        filterPanel = new javax.swing.JPanel();
        typeTwin = new javax.swing.JCheckBox();
        typeKing = new javax.swing.JCheckBox();
        typeQueen = new javax.swing.JCheckBox();
        typeDeluxe = new javax.swing.JCheckBox();
        typeSingle = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listRoomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listRoomPanel.setAutoscrolls(true);

        javax.swing.GroupLayout innerRoomPanelLayout = new javax.swing.GroupLayout(innerRoomPanel);
        innerRoomPanel.setLayout(innerRoomPanelLayout);
        innerRoomPanelLayout.setHorizontalGroup(
            innerRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        innerRoomPanelLayout.setVerticalGroup(
            innerRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout listRoomPanelLayout = new javax.swing.GroupLayout(listRoomPanel);
        listRoomPanel.setLayout(listRoomPanelLayout);
        listRoomPanelLayout.setHorizontalGroup(
            listRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(innerRoomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        listRoomPanelLayout.setVerticalGroup(
            listRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(innerRoomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        namaLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        namaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaLabel.setText("HOTEL");
        namaLabel.setToolTipText("NAMA HOTEL");

        jalanLabel.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jalanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        filterPanel.setBackground(new java.awt.Color(255, 255, 255));
        filterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        typeTwin.setText("Twin");
        typeTwin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTwinActionPerformed(evt);
            }
        });

        typeKing.setText("King");
        typeKing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeKingActionPerformed(evt);
            }
        });

        typeQueen.setText("Queen");
        typeQueen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeQueenActionPerformed(evt);
            }
        });

        typeDeluxe.setText("Deluxe");
        typeDeluxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeDeluxeActionPerformed(evt);
            }
        });

        typeSingle.setText("Single");
        typeSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeSingleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeTwin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeKing, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeQueen, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeDeluxe, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeTwin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeKing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeQueen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeDeluxe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeSingle)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTextField1.setText("Search..");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(namaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jalanLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jalanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listRoomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listRoomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void typeTwinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTwinActionPerformed
        if (typeTwin.isSelected()) {
            this.filterType.add("Twin");
            deleteList();
            renderList();
        } else {
            this.filterType.remove("Twin");
            deleteList();
            renderList();
        }
    }//GEN-LAST:event_typeTwinActionPerformed

    private void typeKingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeKingActionPerformed
        if (typeKing.isSelected()) {
            this.filterType.add("King");
            deleteList();
            renderList();
        } else {
            this.filterType.remove("King");
            deleteList();
            renderList();
        }
    }//GEN-LAST:event_typeKingActionPerformed

    private void typeQueenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeQueenActionPerformed
        if (typeQueen.isSelected()) {
            this.filterType.add("Queen");
            deleteList();
            renderList();
        } else {
            this.filterType.remove("Queen");
            deleteList();
            renderList();
        }
    }//GEN-LAST:event_typeQueenActionPerformed

    private void typeDeluxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeDeluxeActionPerformed
        if (typeDeluxe.isSelected()) {
            this.filterType.add("Deluxe");
            deleteList();
            renderList();
        } else {
            this.filterType.remove("Deluxe");
            deleteList();
            renderList();
        }
    }//GEN-LAST:event_typeDeluxeActionPerformed

    private void typeSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeSingleActionPerformed
        if (typeSingle.isSelected()) {
            this.filterType.add("Single");
            deleteList();
            renderList();
        } else {
            this.filterType.remove("Single");
            deleteList();
            renderList();
        }
    }//GEN-LAST:event_typeSingleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiHotel().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel filterPanel;
    private javax.swing.JPanel innerRoomPanel;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jalanLabel;
    private javax.swing.JPanel listRoomPanel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JCheckBox typeDeluxe;
    private javax.swing.JCheckBox typeKing;
    private javax.swing.JCheckBox typeQueen;
    private javax.swing.JCheckBox typeSingle;
    private javax.swing.JCheckBox typeTwin;
    // End of variables declaration//GEN-END:variables
}
