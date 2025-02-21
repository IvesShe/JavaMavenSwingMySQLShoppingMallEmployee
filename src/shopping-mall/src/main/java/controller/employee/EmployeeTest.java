package controller.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Employee;

public class EmployeeTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmployeeTest frame = new EmployeeTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public EmployeeTest() {
        setTitle("員工管理系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // **🔹 表格標題**
        String[] columnNames = {"ID", "編號", "使用者帳號", "名字", "電話", "地址"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        // **🔹 設定表格不可編輯**
        table.setDefaultEditor(Object.class, null);

        // **🔹 加入 JScrollPane（滾動條）**
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // **🔹 按鈕「載入資料」**
        JButton btnLoadData = new JButton("載入員工資料");
        contentPane.add(btnLoadData, BorderLayout.SOUTH);

        // **🔹 按鈕事件：點擊後載入員工數據**
        btnLoadData.addActionListener(e -> loadTableData(getEmployeeData()));
    }

    // **🔹 取得 List<Employee> 數據**
    private List<Employee> getEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("e021", "emp001","123", "王小明", "0912-345-678", "台北市信義區"));
        employees.add(new Employee("e022", "emp002","123", "陳大同", "0922-888-999", "新北市板橋區"));
        employees.add(new Employee("e023", "emp003","123", "李美麗", "0987-654-321", "台中市西屯區"));
//        employees.add(new Employee(4, "E004", "emp004", "張建宏", "0933-112-233", "高雄市左營區"));
        return employees;
    }

    // **🔹 載入 List 到 JTable**
    private void loadTableData(List<Employee> employees) {
        model.setRowCount(0); // 清空表格
        for (Employee emp : employees) {
            model.addRow(new Object[]{
                emp.getId(),
                emp.getEmployeeNo(),
                emp.getUsername(),
                emp.getPassword(),
                emp.getName(),
                emp.getPhone(),
                emp.getAddress()
            });
        }
    }
}

