package VtysProje.views;

import VtysProje.dao.UserDao;
import VtysProje.model.User;
import VtysProje.util.DataModelsInitializer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 8.12.2017 part of project vtysProje
 */
public class UsersView extends javax.swing.JPanel {

    private UserDao userDao = new UserDao();

    private List<User> users = new ArrayList<>();

    private void refreshUsers() {
        users = userDao.getAll();
        jTable_users_list.setModel(DataModelsInitializer.initUsersTableModel(users));
    }

    /**
     * Creates new form UsersView
     */
    public UsersView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_users = new javax.swing.JPanel();
        jTabbedPane_users = new javax.swing.JTabbedPane();
        jPanel_users_add = new javax.swing.JPanel();
        jTextField_users_add_username = new javax.swing.JTextField();
        jLabel_users_add_username = new javax.swing.JLabel();
        jLabel_users_add_firstName = new javax.swing.JLabel();
        jTextField_users_add_firstName = new javax.swing.JTextField();
        jButton_users_add = new javax.swing.JButton();
        jComboBox_users_add_city = new javax.swing.JComboBox<>();
        jLabel_users_add_city = new javax.swing.JLabel();
        jTextField_users_add_lastName = new javax.swing.JTextField();
        jLabel_users_add_lastName = new javax.swing.JLabel();
        jLabel_users_add_password = new javax.swing.JLabel();
        jTextField_users_add_password = new javax.swing.JTextField();
        jScrollPane_users_add_address = new javax.swing.JScrollPane();
        jTextArea_users_add_address = new javax.swing.JTextArea();
        jLabel_users_add_address = new javax.swing.JLabel();
        jLabel_users_add_phoneNumber = new javax.swing.JLabel();
        jTextField_users_add_phoneNumber = new javax.swing.JTextField();
        jComboBox_users_add_role = new javax.swing.JComboBox<>();
        jLabel_users_add_role = new javax.swing.JLabel();
        jPanel_users_list = new javax.swing.JPanel();
        jScrollPane_users_list = new javax.swing.JScrollPane();
        jTable_users_list = new javax.swing.JTable();

        jTextField_users_add_username.setText("Username");

        jLabel_users_add_username.setText("Username:");

        jLabel_users_add_firstName.setText("First name:");

        jTextField_users_add_firstName.setText("First name");

        jButton_users_add.setText("Add");

        jComboBox_users_add_city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ankara", "London", "New York", "Fizan"}));

        jLabel_users_add_city.setText("City:");

        jTextField_users_add_lastName.setText("Last name");

        jLabel_users_add_lastName.setText("Last name:");

        jLabel_users_add_password.setText("Password:");

        jTextField_users_add_password.setText("Password");

        jTextArea_users_add_address.setColumns(20);
        jTextArea_users_add_address.setRows(5);
        jTextArea_users_add_address.setText("Address");
        jScrollPane_users_add_address.setViewportView(jTextArea_users_add_address);

        jLabel_users_add_address.setText("Address:");

        jLabel_users_add_phoneNumber.setText("Phone number:");

        jTextField_users_add_phoneNumber.setText("Phone number");

        jComboBox_users_add_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Employee", "Customer"}));

        jLabel_users_add_role.setText("Role:");

        javax.swing.GroupLayout jPanel_users_addLayout = new javax.swing.GroupLayout(jPanel_users_add);
        jPanel_users_add.setLayout(jPanel_users_addLayout);
        jPanel_users_addLayout.setHorizontalGroup(
                jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_users_addLayout.createSequentialGroup()
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_users_addLayout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel_users_add_username)
                                                        .addComponent(jLabel_users_add_firstName)
                                                        .addComponent(jLabel_users_add_lastName)
                                                        .addComponent(jLabel_users_add_password)
                                                        .addComponent(jLabel_users_add_address)
                                                        .addComponent(jLabel_users_add_phoneNumber)
                                                        .addComponent(jLabel_users_add_city)
                                                        .addComponent(jLabel_users_add_role))
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox_users_add_city, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_users_add_username, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_users_add_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_users_add_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_users_add_password, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane_users_add_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_users_add_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jComboBox_users_add_role, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel_users_addLayout.createSequentialGroup()
                                                .addGap(218, 218, 218)
                                                .addComponent(jButton_users_add, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel_users_addLayout.setVerticalGroup(
                jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_users_addLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_users_add_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_role))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_users_add_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_username))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_users_add_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_firstName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_users_add_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_lastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_users_add_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_password))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_users_add_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_phoneNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_users_add_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_city))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_users_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane_users_add_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_users_add_address))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_users_add)
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane_users.addTab("Add", jPanel_users_add);

        jTable_users_list.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "Id", "City", "Username", "First name", "Last name", "Password", "Address", "Phone Number", "Role"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable_users_list.setColumnSelectionAllowed(true);
        jScrollPane_users_list.setViewportView(jTable_users_list);

        javax.swing.GroupLayout jPanel_users_listLayout = new javax.swing.GroupLayout(jPanel_users_list);
        jPanel_users_list.setLayout(jPanel_users_listLayout);
        jPanel_users_listLayout.setHorizontalGroup(
                jPanel_users_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_users_listLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane_users_list, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel_users_listLayout.setVerticalGroup(
                jPanel_users_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel_users_listLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane_users_list, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane_users.addTab("List", jPanel_users_list);

        javax.swing.GroupLayout jPanel_usersLayout = new javax.swing.GroupLayout(jPanel_users);
        jPanel_users.setLayout(jPanel_usersLayout);
        jPanel_usersLayout.setHorizontalGroup(
                jPanel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane_users)
        );
        jPanel_usersLayout.setVerticalGroup(
                jPanel_usersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane_users)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 733, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 427, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel_users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_users_add;
    private javax.swing.JComboBox<String> jComboBox_users_add_city;
    private javax.swing.JComboBox<String> jComboBox_users_add_role;
    private javax.swing.JLabel jLabel_users_add_address;
    private javax.swing.JLabel jLabel_users_add_city;
    private javax.swing.JLabel jLabel_users_add_firstName;
    private javax.swing.JLabel jLabel_users_add_lastName;
    private javax.swing.JLabel jLabel_users_add_password;
    private javax.swing.JLabel jLabel_users_add_phoneNumber;
    private javax.swing.JLabel jLabel_users_add_role;
    private javax.swing.JLabel jLabel_users_add_username;
    private javax.swing.JPanel jPanel_users;
    private javax.swing.JPanel jPanel_users_add;
    private javax.swing.JPanel jPanel_users_list;
    private javax.swing.JScrollPane jScrollPane_users_add_address;
    private javax.swing.JScrollPane jScrollPane_users_list;
    private javax.swing.JTabbedPane jTabbedPane_users;
    private javax.swing.JTable jTable_users_list;
    private javax.swing.JTextArea jTextArea_users_add_address;
    private javax.swing.JTextField jTextField_users_add_firstName;
    private javax.swing.JTextField jTextField_users_add_lastName;
    private javax.swing.JTextField jTextField_users_add_password;
    private javax.swing.JTextField jTextField_users_add_phoneNumber;
    private javax.swing.JTextField jTextField_users_add_username;
    // End of variables declaration//GEN-END:variables
}