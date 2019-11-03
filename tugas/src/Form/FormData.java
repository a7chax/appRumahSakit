/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author asus
 */
public class FormData extends javax.swing.JInternalFrame {
    
    DefaultTableModel model;
    koneksi konek = new koneksi();
    
    Date tglSekarang = new Date();
    
    //menentukan format tanggal
    SimpleDateFormat formatTgl = new
        SimpleDateFormat("yyyy-MM-dd");

    
    /**
     * Creates new form FormData
     */
    //consturctor
    public FormData() {
        initComponents();
        loadData("","");
    }
    //menampilkan data berdasarkan kata kunci
    private void loadData(String Key, String fk){
        model = new DefaultTableModel();
        
        tableDataPasien.setModel(model);
        
        model.addColumn("Nama");
        model.addColumn("Kartu Identitas");
        model.addColumn("No. kartu identitas");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tempat tanggal lahir");
        model.addColumn("Status");
        model.addColumn("Nama Wali");
        model.addColumn("No.telp");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = konek.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "";
            
            if (Key.isEmpty()) {
                sql = "SELECT * FROM dbDataPasien";
            } else {
                sql = "SELECT * FROM dbDataPasien WHERE namaPasien "
                        + "LIKE '%"+ Key + "%'";
            }
            
            if (Key.isEmpty() && fk.isEmpty()) {
                /// jika key kosong dan fk kosong
                sql = "SELECT * FROM dbDataPasien";
            } else if(Key.isEmpty() && !fk.isEmpty()){
                sql = "SELECT * FROM dbDataPasien WHERE jenisKelaminPasien = '"+ fk +"'";
            } else if(!Key.isEmpty() && fk.isEmpty()){
                sql = "SELECT * FROM dbDataPasien WHERE namaPasien "
                        + "LIKE '%"+ Key + "%'";
            } else {
                sql = "SELECT * FROM dbDataPasien WHERE namaPasien "
                        + "LIKE '%"+ Key + "%' AND jenisKelaminPasien = '"+ fk +"'";                
            }
                    
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {                
                Object[] obj = new Object[8];
                
                obj[0] = rs.getString("namaPasien");
                obj[1] = rs.getString("kartuIdentitasPasien");
                obj[2] = rs.getString("noKartuIdentitasPasien");
                obj[3] = rs.getString("jenisKelaminPasien");
                obj[4] = rs.getString("tempatTanggalLahirPasien");
                obj[5] = rs.getString("statusPasien");
                obj[6] = rs.getString("namaWaliPasien");
                obj[7] = rs.getString("noTelpPasien");
                
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    //menampilkan data 
    private void loadData(int order){
        model = new DefaultTableModel();
        
        tableDataPasien.setModel(model);
        
        model.addColumn("Nama");
        model.addColumn("Kartu Identitas");
        model.addColumn("No. kartu identitas");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Tempat tanggal lahir");
        model.addColumn("Status");
        model.addColumn("Nama Wali");
        model.addColumn("No.telp");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Connection c = konek.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "";
            
            switch (order) {
                case 1: sql = "SELECT * FROM dbDataPasien ORDER BY namaPasien ASC";
                break;
                case 2: sql = "SELECT * FROM dbDataPasien ORDER BY namaPasien DESC";
                break;
                case 3: sql = "SELECT * FROM dbDataPasien ORDER BY tempatTanggalLahirPasien ASC";
                break;
                case 4: sql = "SELECT * FROM dbDataPasien ORDER BY tempatTanggalLahirPasien DESC";
                break;
                case 5: sql = "SELECT * FROM dbDataPasien ORDER BY kartuIdentitasPasien ASC";
                break;
                default:sql = "SELECT * FROM dbDataPasien";
                break;
               
                
            }
                    
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {                
                Object[] obj = new Object[8];
                
                obj[0] = rs.getString("namaPasien");
                obj[1] = rs.getString("kartuIdentitasPasien");
                obj[2] = rs.getString("noKartuIdentitasPasien");
                obj[3] = rs.getString("jenisKelaminPasien");
                obj[4] = rs.getString("tempatTanggalLahirPasien");
                obj[5] = rs.getString("statusPasien");
                obj[6] = rs.getString("namaWaliPasien");
                obj[7] = rs.getString("noTelpPasien");
                
                model.addRow(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNamaPasien = new javax.swing.JTextField();
        txtKartuIdentitasPasien = new javax.swing.JTextField();
        jComboJenisKelaminPasien = new javax.swing.JComboBox<>();
        jComboStatusPasien = new javax.swing.JComboBox<>();
        txtNamaWaliPasien = new javax.swing.JTextField();
        txtNoTelpPasien = new javax.swing.JTextField();
        txtTempatTanggalLahirPasien = new com.toedter.calendar.JDateChooser();
        txtNamaPenjaminPasien = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNoTelpPenjaminPasien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNamaPetugasPasien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtShiftPetugasPasien = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNoKartuIdentitasPasien = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataPasien = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        cboSortBy = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDokterPasien = new javax.swing.JTextField();
        jComboJenisRawatPasien = new javax.swing.JComboBox<>();
        rButtonUmum = new javax.swing.JRadioButton();
        rButtonLab = new javax.swing.JRadioButton();
        rButtonUGD = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        cboFilterKelamin = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jCheckBox1.setText("jCheckBox1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(230, 223, 223));

        jLabel2.setText("Nama");

        jLabel3.setText("Kartu Identitas");

        jLabel4.setText("No. kartu identitas");

        jLabel5.setText("Jenis kelamin");

        jLabel6.setText("Tempat tanggal lahir");

        jLabel7.setText("Status");

        jLabel8.setText("Nama wali");

        jLabel9.setText("No. Telp");

        jComboJenisKelaminPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));

        jComboStatusPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum menikah", "Menikah" }));

        txtNamaWaliPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaWaliPasienActionPerformed(evt);
            }
        });

        txtNamaPenjaminPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPenjaminPasienActionPerformed(evt);
            }
        });

        jLabel12.setText("Nama Penjamin");

        jLabel13.setText("No.telp penjamin");

        txtNamaPetugasPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPetugasPasienActionPerformed(evt);
            }
        });

        jLabel14.setText("Nama Petugas");

        txtShiftPetugasPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShiftPetugasPasienActionPerformed(evt);
            }
        });

        jLabel15.setText("Shift");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboJenisKelaminPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addComponent(txtTempatTanggalLahirPasien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtKartuIdentitasPasien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(txtNoKartuIdentitasPasien, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(131, 131, 131)
                                .addComponent(txtShiftPetugasPasien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(65, 65, 65)
                                .addComponent(txtNamaPetugasPasien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(46, 46, 46)
                                .addComponent(txtNoTelpPenjaminPasien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(57, 57, 57)
                                .addComponent(txtNamaPenjaminPasien))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(108, 108, 108)
                                .addComponent(txtNoTelpPasien))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNamaWaliPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jComboStatusPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtKartuIdentitasPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNoKartuIdentitasPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboJenisKelaminPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTempatTanggalLahirPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboStatusPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3))
                    .addComponent(txtNamaWaliPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNoTelpPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNamaPenjaminPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNoTelpPenjaminPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNamaPetugasPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtShiftPetugasPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jButton3.setText("Batal");

        tableDataPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tableDataPasien.setEditingColumn(6);
        tableDataPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataPasien);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        cboSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama (A - Z)", "Nama (Z - A)", "Tanggal lahir (A - Z)", "Tanggal lahir (Z - A)" }));
        cboSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSortByActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(230, 223, 223));

        jLabel16.setText("Check up");

        jLabel17.setText("Dokter");

        jLabel18.setText("Jenis Rawat");

        jLabel19.setText("Check");

        txtDokterPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDokterPasienActionPerformed(evt);
            }
        });

        jComboJenisRawatPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rawat inap", "One day care", "Rawat jalan" }));

        rButtonUmum.setText("Umum");

        rButtonLab.setText("Lab");

        rButtonUGD.setText("UGD");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDokterPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(rButtonUmum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rButtonLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rButtonUGD))
                    .addComponent(jComboJenisRawatPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rButtonUmum)
                    .addComponent(rButtonLab)
                    .addComponent(rButtonUGD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDokterPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboJenisRawatPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter Data"));

        jLabel20.setText("Jenis Kelamin");

        cboFilterKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        btnFilter.setText("Submit");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(cboFilterKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboFilterKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(btnFilter)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari)
                            .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(jButton3)
                            .addComponent(btnSubmit)
                            .addComponent(btnHapus))))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDokterPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDokterPasienActionPerformed
   // TODO add your handling code here:
    }//GEN-LAST:event_txtDokterPasienActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String nama_pasien = txtNamaPasien.getText();
        String kartu_identitas_pasien = txtKartuIdentitasPasien.getText();
        String no_kartu_identitas_pasien = txtNoKartuIdentitasPasien.getText();
        String jenis_kelamin_pasien = String.valueOf(jComboJenisKelaminPasien.getSelectedItem());
        String tempat_tanggal_lahir_pasien = formatTgl.format(txtTempatTanggalLahirPasien.getDate());
        String status_pasien =  String.valueOf(jComboStatusPasien.getSelectedItem());
        String nama_wali_pasien = txtNamaWaliPasien.getText();
        String no_telp_pasien = txtNoTelpPasien.getText();
        String nama_penjamin_pasien = txtNamaPenjaminPasien.getText();
        String no_telp_penjamin_pasien = txtNoTelpPenjaminPasien.getText();
        String nama_petugas_pasien = txtNamaPetugasPasien.getText();
        String shift_petugas_pasien = txtShiftPetugasPasien.getText();
        //Radio Button below
        String  check_up_pasien = "";
            if(rButtonUmum.isSelected()){
                check_up_pasien = "Umum";
            } else if(rButtonLab.isSelected()){
                check_up_pasien = "Lab";
            } else if(rButtonUGD.isSelected()){
                check_up_pasien = "UGD";
            }
        //end of radio button
        String dokter_pasien = txtDokterPasien.getText();
        String jenis_rawat_pasien = String.valueOf(jComboJenisRawatPasien.getSelectedItem());      
        
        
        
        try {
            Connection c = konek.getKoneksi();
            String sql = "INSERT INTO dbDataPasien(`namaPasien`, `kartuIdentitasPasien`, `noKartuIdentitasPasien`, `jenisKelaminPasien`, `tempatTanggalLahirPasien`, `statusPasien`, `namaWaliPasien`, `noTelpPasien`, `namaPenjaminPasien`, `noTelpPenjaminPasien`, `namaPetugasPasien`, `shiftPetugasPasien`, `checkUpPasien`, `dokterPasien`, `jenisRawatPasien`) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1,nama_pasien);
            p.setString(2,kartu_identitas_pasien);
            p.setString(3,no_kartu_identitas_pasien);
            p.setString(4,jenis_kelamin_pasien);
            p.setString(5,tempat_tanggal_lahir_pasien);
            p.setString(6,status_pasien);
            p.setString(7,nama_wali_pasien);
            p.setString(8,no_telp_pasien);
            p.setString(9,nama_penjamin_pasien);
            p.setString(10,no_telp_penjamin_pasien);
            p.setString(11,nama_petugas_pasien);
            p.setString(12,shift_petugas_pasien);
            p.setString(13,check_up_pasien);
            p.setString(14,dokter_pasien);
            p.setString(15,jenis_rawat_pasien);
            
            p.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Gagal Input data");
        }finally{
            JOptionPane.showMessageDialog(rootPane,
                    "Berhasil menyimpan data","berhasil",
                    JOptionPane.INFORMATION_MESSAGE);
            
                    loadData("","");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtNamaWaliPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaWaliPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaWaliPasienActionPerformed

    private void txtNamaPenjaminPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPenjaminPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPenjaminPasienActionPerformed

    private void txtShiftPetugasPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShiftPetugasPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShiftPetugasPasienActionPerformed

    private void tableDataPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataPasienMouseClicked
        // TODO add your handling code here:
        int i = tableDataPasien.getSelectedRow();
        if (i == -1) {
            return;
        }
        String nama_pasien = (String) model.getValueAt(i, 0);
        String kartu_identitas_pasien = (String) model.getValueAt(i, 1);
        String no_kartu_identitas_pasien = (String) model.getValueAt(i, 2);
        String jenis_kelamin_pasien = (String) model.getValueAt(i, 3);
        String tempat_tanggal_lahir_pasien = (String) model.getValueAt(i, 4);
            
            Date tanggal = null;
                try {
                    tanggal = new SimpleDateFormat("yyyy-MM-dd")
                            .parse(tempat_tanggal_lahir_pasien);
                } catch (ParseException ex) {
                    Logger.getLogger(FormData.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                //menampilkan tanggal ke jcalendar
                txtTempatTanggalLahirPasien.setDate(tanggal);
                
        String status_pasien = (String) model.getValueAt(i, 5);
        String nama_wali_pasien = (String) model.getValueAt(i, 6);
        String no_telp_pasien = (String) model.getValueAt(i, 7);
        String nama_penjamin_pasien, no_telp_penjamin_pasien, nama_petugas_pasien, shift_petugas_pasien, check_up_pasien, dokter_pasien, jenis_rawat_pasien;
        
        
        
        try {
            Connection c = konek.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT namaPenjaminPasien,noTelpPenjaminPasien,namaPetugasPasien,shiftPetugasPasien,checkUpPasien,dokterPasien,jenisRawatPasien FROM "
                        + "dbDataPasien WHERE kartuIdentitasPasien = '" + kartu_identitas_pasien +"'";
            
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
                Object[] obj = new Object[7];
                nama_penjamin_pasien = rs.getString("namaPenjaminPasien");
                no_telp_penjamin_pasien = rs.getString("noTelpPenjaminPasien");
                nama_petugas_pasien = rs.getString("namaPetugasPasien");
                shift_petugas_pasien = rs.getString("shiftPetugasPasien");
                check_up_pasien = rs.getString("checkUpPasien");
                
  
                if (check_up_pasien.equals("Umum")) {
                    rButtonUmum.setSelected(true);
                    rButtonUGD.setSelected(false);
                    rButtonLab.setSelected(false);
                } else if(check_up_pasien.equals("UGD")){
                    rButtonUGD.setSelected(true);
                    rButtonUmum.setSelected(false);
                    rButtonLab.setSelected(false);
                } else {
                    rButtonLab.setSelected(true);
                    rButtonUmum.setSelected(false);
                    rButtonUGD.setSelected(false);
                }
                
                dokter_pasien = rs.getString("dokterPasien");
                jenis_rawat_pasien = rs.getString("jenisRawatPasien");
                
                jComboJenisRawatPasien.setSelectedItem(jenis_rawat_pasien);
                txtNamaPenjaminPasien.setText(nama_penjamin_pasien);
                txtNoTelpPenjaminPasien.setText(no_telp_penjamin_pasien);
                txtNamaPetugasPasien.setText(nama_petugas_pasien);
                txtShiftPetugasPasien.setText(shift_petugas_pasien);
                txtDokterPasien.setText(dokter_pasien);
                
            }
            
         
        } catch(SQLException e) {
            System.err.println("gagal" + e);
        } 
        
        txtNamaPasien.setText(nama_pasien);
        txtKartuIdentitasPasien.setText(kartu_identitas_pasien);
        txtNoKartuIdentitasPasien.setText(no_kartu_identitas_pasien);
        jComboJenisKelaminPasien.setSelectedItem(jenis_kelamin_pasien);
        txtTempatTanggalLahirPasien.setDate(tanggal);
        jComboStatusPasien.setSelectedItem(status_pasien);
        txtNamaWaliPasien.setText(nama_wali_pasien);
        txtNoTelpPasien.setText(no_telp_pasien);
             
    }//GEN-LAST:event_tableDataPasienMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String cariData = txtSearch.getText();
        loadData(cariData,"");
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String cariData = txtSearch.getText();
        loadData(cariData,"");
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtNamaPetugasPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPetugasPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPetugasPasienActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        //GEN-FIRST : btnUbahActionPerformed
        String nama_pasien = txtNamaPasien.getText();
        String kartu_identitas_pasien = txtKartuIdentitasPasien.getText();
        String no_kartu_identitas_pasien = txtNoKartuIdentitasPasien.getText();
        String jenis_kelamin_pasien = (String) jComboJenisKelaminPasien.getSelectedItem();
        Date tgl = txtTempatTanggalLahirPasien.getDate();
        String tempat_tanggal_lahir_pasien = formatTgl.format(tgl);
        String status_pasien = (String) jComboStatusPasien.getSelectedItem();
        String nama_wali_pasien = txtNamaWaliPasien.getText();
        String no_telp_pasien = txtNoTelpPasien.getText();
        String nama_penjamin_pasien = txtNamaPenjaminPasien.getText();
        String no_telp_penjamin_pasien = txtNoTelpPenjaminPasien.getText();
        String nama_petugas_pasien = txtNamaPetugasPasien.getText();
        String shift_petugas_pasien = txtShiftPetugasPasien.getText();
       
        String  check_up_pasien = "";
            if(rButtonUmum.isSelected()){
                check_up_pasien = "Umum";
            } else if(rButtonLab.isSelected()){
                check_up_pasien = "Lab";
            } else if(rButtonUGD.isSelected()){
                check_up_pasien = "UGD";
            }
        String dokter_pasien = txtDokterPasien.getText();
        String jenis_rawat_pasien = (String) jComboJenisRawatPasien.getSelectedItem();
        
        try {
            Connection c = konek.getKoneksi();
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
                    String sql = "UPDATE dbDataPasien SET "
                            + "`namaPasien`=?,"
                            + "`noKartuIdentitasPasien`=?,"
                            + "`jenisKelaminPasien`=?,"
                            + "`tempatTanggalLahirPasien`=?,"
                            + "`statusPasien`=?,"
                            + "`namaWaliPasien`=?,"
                            + "`noTelpPasien`=?,"
                            + "`namaPenjaminPasien`=?,"
                            + "`noTelpPenjaminPasien`=?,"
                            + "`namaPetugasPasien`=?,"
                            + "`shiftPetugasPasien`=?,"
                            + "`checkUpPasien`=?,"
                            + "`dokterPasien`=?,"
                            + "`jenisRawatPasien`=? WHERE kartuIdentitasPasien=?";
                    try(PreparedStatement p = c.prepareStatement(sql)){
                        p.setString(1, nama_pasien);
                        p.setString(2, no_kartu_identitas_pasien);
                        p.setString(3, jenis_kelamin_pasien);
                        p.setString(4, tempat_tanggal_lahir_pasien);
                        p.setString(5, status_pasien);
                        p.setString(6, nama_wali_pasien);
                        p.setString(7, no_telp_pasien);
                        p.setString(8, nama_penjamin_pasien);
                        p.setString(9, no_telp_penjamin_pasien);
                        p.setString(10, nama_petugas_pasien);
                        p.setString(11, shift_petugas_pasien);
                        p.setString(12, check_up_pasien);
                        p.setString(13, dokter_pasien);
                        p.setString(14, jenis_rawat_pasien);
                        p.setString(15, kartu_identitas_pasien);
                        
                        p.executeUpdate();
                    
                    }
                    
        } catch (SQLException e) {
            System.err.println("Error saat menyimpan data : \n" + e);
        } finally{
//            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan",JOptionPane.CLOSED_OPTION);
            
            loadData("","");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String kartu_identitas_pasien = txtKartuIdentitasPasien.getText();
        int i = JOptionPane.showConfirmDialog(rootPane, "Apakah ingin menghapus data ?", 
                "konfirmasi hapus", JOptionPane.OK_CANCEL_OPTION);
        
        if (i == 0) {
            try {
                Connection c = konek.getKoneksi();
                Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                
                String sql = "DELETE FROM dbDataPasien WHERE kartuIdentitasPasien=?";
                
                try(PreparedStatement p = c.prepareStatement(sql)){
                    p.setString(1, kartu_identitas_pasien);
                    p.executeUpdate();
                }
            } catch (SQLException e) {
                System.err.println("Error saat menghapus data: \n " + e);
            } finally {
                loadData("","");
            }
        }
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cboSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSortByActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String order = String.valueOf(cboSortBy.getSelectedItem());
        
        /**
         * Nama (A - Z), Nama (Z - A), Tanggal Lahir (A - Z), Tanggal Lahir (Z - A), No. Induk
         */
        
        //memanggil method loadData sesuai kondisi
        if(order.equals("Nama (A - Z)")){
            loadData(1);
        }else if (order.equals("Nama (Z - A)")) {
            loadData(2);
        }else if(order.equals("Tanggal lahir (A - Z)")){
            loadData(3);
        }else if(order.equals("Tanggal lahir (Z - A)")){
            loadData(4);
        }else{
            loadData(5);
        }
    }//GEN-LAST:event_cboSortByActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        String fk = String.valueOf(cboFilterKelamin.getSelectedItem());
        String Key  = txtSearch.getText();
        
        loadData(Key, fk);
    }//GEN-LAST:event_btnFilterActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboFilterKelamin;
    private javax.swing.JComboBox<String> cboSortBy;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboJenisKelaminPasien;
    private javax.swing.JComboBox<String> jComboJenisRawatPasien;
    private javax.swing.JComboBox<String> jComboStatusPasien;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rButtonLab;
    private javax.swing.JRadioButton rButtonUGD;
    private javax.swing.JRadioButton rButtonUmum;
    private javax.swing.JTable tableDataPasien;
    private javax.swing.JTextField txtDokterPasien;
    private javax.swing.JTextField txtKartuIdentitasPasien;
    private javax.swing.JTextField txtNamaPasien;
    private javax.swing.JTextField txtNamaPenjaminPasien;
    private javax.swing.JTextField txtNamaPetugasPasien;
    private javax.swing.JTextField txtNamaWaliPasien;
    private javax.swing.JTextField txtNoKartuIdentitasPasien;
    private javax.swing.JTextField txtNoTelpPasien;
    private javax.swing.JTextField txtNoTelpPenjaminPasien;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtShiftPetugasPasien;
    private com.toedter.calendar.JDateChooser txtTempatTanggalLahirPasien;
    // End of variables declaration//GEN-END:variables
}
