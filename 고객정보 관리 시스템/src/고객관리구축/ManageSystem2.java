package ����������;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * <<�����̷�(Modification Informaiton)>>
 * ������         ������      �۾�(��������)
 *-----         ------      ------------
 *2021.10.07   ������      ���̾ƿ� ���� ,menuMain ������ ���� 
 *2021.10.08   ������
 *
 */
//�ܺ�Ŭ����
public class ManageSystem2 extends JFrame { // JFrame Ŭ������ �ֻ��� �����̳� ������ Ŭ�����̴�.

   public static final String String = null;
   // ���� Ŭ���� ��ü ���� => ���� Ŭ���� �� ������������ ���� �����̴�.
   MenuMain menuMain = new MenuMain();
   West west = new West();
   Buttons buttons = new Buttons();
   ShowTable showTable = new ShowTable(); // --> ������ �ۿ� ��ü�� ���� ������ �۷ι� �������� ��𿡼��� �� �����ϱ� ���ؼ�

   // ������
   public ManageSystem2() {
      OUTTER: while (true) {// OUTTERó�� �빮�ڸ� ���̺��̶� �θ�
         ImageIcon icon = new ImageIcon("images/customerimage.JPG");
         JOptionPane.showMessageDialog(null, null, "�� ���� ���� �ý���", JOptionPane.NO_OPTION, icon);// Ȯ�� ������ �κ�

         String password = JOptionPane.showInputDialog("�������ý���" + "\n" + "�н����� �Է�");
         String passwd = "";

         if (password == null) {
            break OUTTER;
         } else if (password.equals(passwd)) { // �н����� ���� ó�� ���� �� => ����ȭ�� ���̱�
            setTitle("������ ���� �ý���");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // �߰�
            add(menuMain.bar, BorderLayout.NORTH);
            add(west, BorderLayout.WEST);
            add(buttons, BorderLayout.SOUTH);
            add(showTable.scrollPane, BorderLayout.CENTER);

            setSize(1200, 800);
            setLocation(500, 50);
            setVisible(true);

            break OUTTER;
         } else {
            JOptionPane.showMessageDialog(null, "�н����尡 ���� �ʽ��ϴ�." + "\n" + "'Ȯ��' ��ư�� ��������.", "���� �޼���",
                  JOptionPane.ERROR_MESSAGE);

            continue OUTTER;
         }
      }
   }

   // �޴������ => ����Ŭ����(inner class)
   class MenuMain extends JPanel implements ActionListener, ItemListener {
      JMenuBar bar;
      JMenu file, sort, help;
      JMenuItem fnew, fopen, fsave, fexit, proinfo;
      JCheckBoxMenuItem sno, sname, schul, sjob;

      FileDialog readOpen, saveOpen;
      String fileDir, fileName, savefileName, readjileName;

      ButtonGroup gr = new ButtonGroup();// ������ �ϳ��� �ϱ����� ��ư���� �׷�ȭ ��Ŵ?

      public MenuMain() {// �����ڿ� ��ü�� ����� ȭ�鱸��(UI), �� ��ü(������Ʈ)�� ���� �̺�Ʈ�� ����

         bar = new JMenuBar();

         file = new JMenu("����");
         sort = new JMenu("����");
         help = new JMenu("����");

         fopen = new JMenuItem("����"); // JMenuItem ������Ʈ�� ActionEvent�� �߻�
         fsave = new JMenuItem("����");
         fexit = new JMenuItem("�ݱ�");

         sno = new JCheckBoxMenuItem("��ȣ"); // JCheckBoxMenuItem ������Ʈ�� ItemEvent�� �߻�
         sname = new JCheckBoxMenuItem("�̸�");
         schul = new JCheckBoxMenuItem("����");
         sjob = new JCheckBoxMenuItem("����");

         proinfo = new JMenuItem("���α׷�����");

         // ��ü�� �����̳ʿ� ���̱�/.>?
         file.add(fopen);
         file.add(fsave);
         file.addSeparator();
         file.add(fexit);

         gr.add(sno);
         gr.add(sname);
         gr.add(schul);
         gr.add(sjob);

         sort.add(sno);
         sort.add(sname);
         sort.add(schul);
         sort.add(sjob);

         help.add(proinfo);

         bar.add(file);
         bar.add(sort);
         bar.add(help);

         // ���� �޴� �̺�Ʈ ����
         fopen.addActionListener(this);
         fsave.addActionListener(this);
         fexit.addActionListener(this);

         // ���� �޴� �̺�Ʈ ����
         sno.addItemListener(this); // actionPerformed
         sname.addItemListener(this);
         schul.addItemListener(this);
         sjob.addItemListener(this);
      }

      @Override
      public void itemStateChanged(ItemEvent e) {

      }

      @Override
      public void actionPerformed(ActionEvent e) {

      }

   }
   // end menumain calss

   // �Է� �Ż����� �� West ����Ŭ����

   class West extends JPanel { // JPanel�� ���� �����̳� ������ Ŭ����

      // ���� Ŭ���� ��ü ����
      Input input = new Input();
      Output output = new Output();

      // ������
      public West() {
         setLayout(new BorderLayout());
         add(input, BorderLayout.CENTER);
         add(output, BorderLayout.SOUTH);

      }

      class Input extends JPanel { // �Է� ���� ��� Ŭ����
         JTextField[] tf = new JTextField[5];
         String[] text = { "��ȣ", "�̸�", "�ڵ�����ȣ", "�̸���", "�ֹε�Ϲ�ȣ" };
         String[] jobText = { "����", "ȸ���", "������", "���α׷���", "����", "�л�", "��Ÿ" };
         JLabel la, job;
         JComboBox box;

         // ������
         public Input() { // ȭ�鼳��(UI)
            setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "�Է�"));
            setLayout(new GridLayout(6, 2, 5, 30));

            for (int i = 0; i < text.length; i++) {
               la = new JLabel(text[i]);
               tf[i] = new JTextField(10);
               la.setHorizontalAlignment(JLabel.CENTER);
               add(la);
               add(tf[i]);
            }
            box = new JComboBox(jobText);
            job = new JLabel("����");
            job.setHorizontalAlignment(JLabel.CENTER);
            add(job);
            add(box);
            setPreferredSize(new Dimension(340, 300));
         }
      }
   }

   class Output extends JPanel implements ActionListener {// �Ż����� ��� Ŭ����
      // �߰�
      JPanel info = new JPanel(); // �Ż����� Border ����� JPanel
      JPanel search = new JPanel(); // ���� �˻� JPanel

      CardLayout card = new CardLayout();
      String[] text = { "   ����: ", "   ����: ", "   �������: ", "   ����: " };
      JLabel[] label = new JLabel[4];
      ButtonGroup group = new ButtonGroup();
      JRadioButton[] searchRadio = new JRadioButton[4];
      JButton searchButton;
      JButton exitButton;
      JTextField nameText;
      String[] search_name = { "�̸�", "����", "�������", "����" };
      int searchType;

      // ������
      public Output() {
         // �����ڿ� ��ü�� ����� ȭ�鱸��(UI), �� ��ü(������Ʈ)�� ���� �̺�Ʈ�� ����
         // �Ż����� UI �����
         info.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "�Ż� ����"));
         info.setLayout(new GridLayout(4, 1));

         for (int i = 0; i < text.length; i++) {
            label[i] = new JLabel(text[i], JLabel.LEFT);
            info.add(label[i]);

         }
         // �����˻� UI Border �����
         search.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "���� �˻�"));

         nameText = new JTextField(10);
         searchButton = new JButton("ã��");
         exitButton = new JButton("������");

         searchButton.setBackground(Color.CYAN);
         exitButton.setBackground(Color.LIGHT_GRAY);

         // ��ư ��ü�� �̺�Ʈ �ڵ鷯 ������ ��� (���� ��Ű��)
         searchButton.addActionListener(this);
         exitButton.addActionListener(this);

         setPreferredSize(new Dimension(340, 300));

         int x = -70;
         search.setLayout(null);

         for (int i = 0; i < searchRadio.length; i++) {
            searchRadio[i] = new JRadioButton(search_name[i]);
            searchRadio[i].setBounds(x += 80, 60, 80, 30);
            group.add(searchRadio[i]);
            search.add(searchRadio[i]);

            // �̺�Ʈ ����
            searchRadio[i].addActionListener(this);
         }
         nameText.setBounds(40, 110, 200, 30);
         searchButton.setBounds(35, 170, 80, 30);
         exitButton.setBounds(140, 170, 110, 30);
         search.add(nameText);
         search.add(searchButton);
         search.add(exitButton);

         card = new CardLayout();
         setLayout(card);

         add(info, "�Ż����� ī��");
         add(search, "�����˻� ī��");
      }

      @Override // ������
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("������"))
            goOut();
      }

      // ������ �̺�Ʈ ó�� �޼ҵ�
      public void goOut() {
         west.output.card.show(west.output, "�Ż����� ī��");

      }// �Ż� ���� ��� Ŭ����
         // �߰� ��ư Ŭ�� �� �̺�Ʈ ó�� �޼ҵ�

   } // end west class

// ��ư ����� ���� Ŭ����
   class Buttons extends JPanel implements ActionListener {
      Vector<String> vector;
      JButton addBtn, delBtn, preBtn, nextBtn, updateBtn, searchBtn;
      int age;
      String juminNo, sung, chul;

      // ������
      public Buttons() {
         setLayout(new GridLayout(1, 6));

         addBtn = new JButton("�߰�");
         delBtn = new JButton("����");
         preBtn = new JButton("����");
         nextBtn = new JButton("����");
         updateBtn = new JButton("����");
         searchBtn = new JButton("�˻�");

         addBtn.setBackground(Color.YELLOW);
         delBtn.setBackground(Color.LIGHT_GRAY);
         updateBtn.setBackground(Color.PINK);
         searchBtn.setBackground(Color.GREEN);

         add(addBtn);
         add(delBtn);
         add(preBtn);
         add(nextBtn);
         add(updateBtn);
         add(searchBtn);

         // �̺�Ʈ ���� (�߰� ��ư�� ����)
         addBtn.addActionListener(this);
         delBtn.addActionListener(this);
         preBtn.addActionListener(this);
         nextBtn.addActionListener(this);
         updateBtn.addActionListener(this);
         searchBtn.addActionListener(this);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("�߰�"))
            addDate(); // ����ڰ� �߰���ư�� Ŭ���ߴٸ�? addDate �޼ҵ� ȣ��
         else if (e.getActionCommand().equals("�˻�"))
            searchDate();
      }

      // �߰� ��ư Ŭ���� �̺�Ʈ ó�� �޼ҵ� -> ���� �߿��� �޼ҵ�
      public void addDate() {
         nextBtn.setEnabled(true); //���� ��ư Ȱ��ȭ 
         vector = new Vector<String>();
         vector.add(west.input.tf[0].getText()); //��ȣ �Է� �� �� ���� ��ü�� �߰� 
         vector.add(west.input.tf[1].getText());
         vector.add(west.input.tf[2].getText());
         vector.add(west.input.tf[3].getText());
         
         juminNo = west.input.tf[4].getText();// �Է� ���� �ֹι�ȣ�� �������� üũ����
         
         int sum = 0;
         int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5};
         int temp = 0; 
         int result = 0;
         
         String regex = "^[0-9]{6}-[1234][0-9]{6}$";//�ֹι�ȣ ����ǥ���� �� �ڸ� ù��°�� 1-4������ ���ڰ� �� �� ����. 
         
         boolean check = juminNo.matches(regex);
         
         if(check == false) {
            JOptionPane.showMessageDialog(null, "�ֹι�ȣ�� ���Խ� ���Ͽ� ���� �����ϴ�."+"\n"+"�ֹι�ȣ�� �ٽ� �Է��ϼ���.",
                  "���� �޼���", JOptionPane.ERROR_MESSAGE);
            
            west.input.tf[4].setText(null);
            west.input.tf[4].requestFocus();
            return; //�� ���¸� �״�� �����ض� 
            
         }else if(juminNo.length() == 14) {
            
            //1�ܰ� ���� sum ���ϱ� 
            for (int i=0; i<13; i++) {
               if(juminNo.charAt(i)=='-') continue;
               sum += (juminNo.charAt(i)-48)*weight[i];
                                             
            }
            //2�ܰ� �����ϱ� 
            temp = 11 -(sum % 11);
         
            //3�ܰ� �����ϱ�  
            result = temp%10;
         }
         //�ֹι�ȣ ���� ���� üũ 
         if(result == juminNo.charAt(13)-48) {
            JOptionPane.showMessageDialog(null,
                  "�ֹι�ȣ üũ ��� �����Դϴ�."+"\n" + "'Ȯ��' ��ư�� ����� ������ ��� �˴ϴ�.");
            vector.add(juminNo);
            
            Calendar cal = Calendar.getInstance(Locale.KOREA);
            int year = cal.get(Calendar.YEAR); //2021 ����
            
            int yy = Integer.parseInt(juminNo.substring(0, 2));
            
            if((juminNo.charAt(7)-48) < 3) { 
               yy = yy + 1900 ;
            }else {
               yy = yy + 2000; 
            }
             
            int age = year - yy + 1; 
         
            //���� �����ϱ� 
            if((juminNo.charAt(7)-48) % 2 == 0) { 
               sung = "����";
            } else{ 
               sung = "����";
            }
         
            String[][]localCode = {{"����","00","08"},{"�λ�","09","12"},{"��õ","13","15"},{"���","16","25"},{"����","26","34"},
                              {"���","35","39"},{"����","40","40"},{"�泲","41","43"},{"�泲","45","47"},{"����","44","44"},{"����","96","96"},
                              {"����","48","54"},{"����","55","64"},{"����","65","65"},{"�뱸","67","70"},{"���","71","80"},{"�泲","81","84"},
                              {"�泲","86","90"},{"���","85","85"},{"����","91","95"}
            };
            
            String localString = juminNo.substring(8, 10); 
            
            int local = Integer.parseInt(localString); 
               String  place = null;
            
            for(int i=0;i<=19;i++) { 
               if(local >= Integer.parseInt(localCode[i][1])
                     && local <= Integer.parseInt(localCode[i][2])) {
                  place = localCode[i][0];
               }
            }
            
            vector.add(String.valueOf(age));
            vector.add(sung);
            vector.add(place);
            vector.add(juminNo.substring(2,4)+"��" + juminNo.substring(4, 6)+"��");
            
            west.output.label[0].setText("   ����: " + "   " + String.valueOf(age));
            west.output.label[1].setText("   ����: " + "   " + sung);
            west.output.label[2].setText("   ��� ����: " + "   " + place);
            west.output.label[3].setText("   ����: " + "   " + 
                     juminNo.substring(2,4)+"��" + juminNo.substring(4, 6)+"��");
            
            vector.add(west.input.box.getSelectedItem().toString());
            
            west.input.tf[0].setText(null);    //��ȣ
            west.input.tf[1].setText(null);      //�̸�
            west.input.tf[2].setText(null);      //����
            west.input.tf[3].setText(null);    //�̸���
            west.input.tf[4].setText(null);      //�ֹι�ȣ
            west.input.box.setSelectedIndex(0);   //�޺��ڽ� ��ü �������� �ٽ� �������� 
            west.input.tf[0].requestFocus(); //��ȣ�� ��Ŀ�� ���߱� 
            
            showTable.data.addElement(vector);
            showTable.datamodel.fireTableDataChanged();
         }else {
            JOptionPane.showMessageDialog(null, "�ֹι�ȣ�� Ʋ��",
                  "���� �޼���", JOptionPane.ERROR_MESSAGE);
            west.input.tf[4].setText(null);
            west.input.tf[4].requestFocus();
            return;
         }
      }
         
      public void searchDate() {
         west.output.card.show(west.output, "�����˻� ī��");
      }
   }// end buttons Ŭ����

   // ���� JTable ����� => ����Ŭ����
   class ShowTable extends MouseAdapter {

      DefaultTableModel datamodel;
      JTable table;
      JScrollPane scrollPane;

      String[] colName = { "��ȣ", "�̸�", "�ڵ�����ȣ", "�̸���", "�ֹι�ȣ", "����", "����", "�������", "����", "����" };

      Vector<Vector<String>> data; // [�߿�]
      Vector<String> column_name;
      int row = -1;

      // ������
      public ShowTable() {
         data = new Vector<Vector<String>>();
         column_name = new Vector<String>();

         for (int i = 0; i < colName.length; i++) {
            column_name.add(colName[i]);
         }
         // 1�ܰ�
         datamodel = new DefaultTableModel(data, column_name) {
            public boolean isCellEditable(int row, int column) {
               return false;
            }

         };
         // 2�ܰ�
         table = new JTable(datamodel);

         // 3�ܰ�
         scrollPane = new JScrollPane(table);

         // �̺�Ʈ ����
         table.addMouseListener(this);
         table.setAutoCreateRowSorter(true);

         TableRowSorter<TableModel> tablesorter = new TableRowSorter<TableModel>(table.getModel());

         table.setRowSorter(tablesorter);
         TableSize();

      }

      public void TableSize() { // J ���̺� �� Ű�� �����ϱ�
         table.getColumnModel().getColumn(0).setPreferredWidth(50); // ��ȣ
         table.getColumnModel().getColumn(1).setPreferredWidth(50);
         table.getColumnModel().getColumn(2).setPreferredWidth(120);
         table.getColumnModel().getColumn(3).setPreferredWidth(150);
         table.getColumnModel().getColumn(4).setPreferredWidth(130);
         table.getColumnModel().getColumn(5).setPreferredWidth(50);
         table.getColumnModel().getColumn(6).setPreferredWidth(50);
         table.getColumnModel().getColumn(7).setPreferredWidth(80);
         table.getColumnModel().getColumn(8).setPreferredWidth(70);
         table.getColumnModel().getColumn(9).setPreferredWidth(50);// ����

      }
   }

   public static void main(String[] args) {
      // ����
      ManageSystem2 ms = new ManageSystem2();
   }
}