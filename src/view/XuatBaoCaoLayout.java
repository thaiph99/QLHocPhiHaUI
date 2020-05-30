/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SinhVienController;
import database.Connect;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;

/**
 *
 * @author quyen
 */
public class XuatBaoCaoLayout extends javax.swing.JPanel {

    Connect connect;
    int type = 0;

    /**
     * Creates new form XuatBaoCaoLayout
     */
    public XuatBaoCaoLayout() {
        connect = new Connect();
        initComponents();
        setSize(1000, 450);
        cbChoose.getSelectedItem();
        if (cbChoose.getSelectedItem().toString().equals("Tất Cả")) {
            hienthidsdv(1);
        } else {
            hienthidsdv(0);
        }
        cbChoose.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                //Do Something
                if (cbChoose.getSelectedItem().toString().equals("Tất Cả")) {
                    hienthidsdv(1);
                } else {
                    hienthidsdv(0);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bangbaocao = new javax.swing.JTable();
        cbChoose = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnXuatbaocao = new javax.swing.JButton();

        bangbaocao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Quê Quán", "Số ĐT", "Gmail", "Mã Lớp", "Công Nợ"
            }
        ));
        jScrollPane1.setViewportView(bangbaocao);

        cbChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Chưa hoàn thành", " " }));
        cbChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChooseActionPerformed(evt);
            }
        });

        jLabel1.setText("Công nợ");
        jLabel1.setToolTipText("");

        btnXuatbaocao.setText("Xuất Báo Cáo");
        btnXuatbaocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatbaocaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(cbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(btnXuatbaocao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXuatbaocao)
                .addGap(147, 147, 147))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChooseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChooseActionPerformed

    private void btnXuatbaocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatbaocaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatbaocaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangbaocao;
    private javax.swing.JButton btnXuatbaocao;
    private javax.swing.JComboBox<String> cbChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void hienthidsdv(int type) {
        if (type == 0) {
            List<SinhVien> list = new ArrayList<>();
            list.clear();
            DefaultTableModel model = (DefaultTableModel) bangbaocao.getModel();
            model.setRowCount(0);
            // truy vấn database và thêm vài list
            ResultSet resultset = connect.queryData("select * from sinhvien where congno < 0");
            try {
                while (resultset.next()) {

                    SinhVien sv = new SinhVien(resultset.getString("masv"), resultset.getString("hoten"), resultset.getString("ngaysinh"), resultset.getString("gioitinh"), resultset.getString("quequan"), resultset.getString("sdt"), resultset.getString("gmail"), resultset.getString("malop"), resultset.getInt("congno") + "");
                    list.add(sv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // thêm sv từ list vào bảng
            for (SinhVien i : list) {

                Object[] row = {i.getMasv(), i.getHoten(), i.getNgaysinh(), i.getGioitinh(), i.getQuequan(), i.getSdt(), i.getGmail(), i.getMalop(), i.getCongno()};
                model.addRow(row);

            }
        } else {
            List<SinhVien> list = new ArrayList<>();
            list.clear();
            DefaultTableModel model = (DefaultTableModel) bangbaocao.getModel();
            model.setRowCount(0);
            // truy vấn database và thêm vài list
            ResultSet resultset = connect.queryData("select * from sinhvien");
            try {
                while (resultset.next()) {

                    SinhVien sv = new SinhVien(resultset.getString("masv"), resultset.getString("hoten"), resultset.getString("ngaysinh"), resultset.getString("gioitinh"), resultset.getString("quequan"), resultset.getString("sdt"), resultset.getString("gmail"), resultset.getString("malop"), resultset.getInt("congno") + "");
                    list.add(sv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // thêm sv từ list vào bảng
            for (SinhVien i : list) {

                Object[] row = {i.getMasv(), i.getHoten(), i.getNgaysinh(), i.getGioitinh(), i.getQuequan(), i.getSdt(), i.getGmail(), i.getMalop(), i.getCongno()};
                model.addRow(row);

            }
        }

    }
}
