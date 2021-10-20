package 고객관리구축;

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
 * <<개정이력(Modification Informaiton)>>
 * 수정일         수정자      작업(수정내용)
 *-----         ------      ------------
 *2021.10.07   한지희      레이아웃 설계 ,menuMain 디자인 구현 
 *2021.10.08   한지희
 *
 */
//외부클래스
public class ManageSystem2 extends JFrame { // JFrame 클래스는 최상위 컨테이너 역할의 클래스이다.

   public static final String String = null;
   // 내부 클래스 객체 생성 => 내부 클래스 각 참조변수들은 전역 개념이다.
   MenuMain menuMain = new MenuMain();
   West west = new West();
   Buttons buttons = new Buttons();
   ShowTable showTable = new ShowTable(); // --> 생성자 밖에 객체를 넣은 이유는 글로벌 개념으로 어디에서든 다 접근하기 위해서

   // 생성자
   public ManageSystem2() {
      OUTTER: while (true) {// OUTTER처럼 대문자를 레이블이라 부름
         ImageIcon icon = new ImageIcon("images/customerimage.JPG");
         JOptionPane.showMessageDialog(null, null, "고객 정보 관리 시스템", JOptionPane.NO_OPTION, icon);// 확인 아이콘 부분

         String password = JOptionPane.showInputDialog("고객관리시스템" + "\n" + "패스워드 입력");
         String passwd = "";

         if (password == null) {
            break OUTTER;
         } else if (password.equals(passwd)) { // 패스워드 인증 처리 성공 시 => 실행화면 보이기
            setTitle("고객정보 관리 시스템");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 추가
            add(menuMain.bar, BorderLayout.NORTH);
            add(west, BorderLayout.WEST);
            add(buttons, BorderLayout.SOUTH);
            add(showTable.scrollPane, BorderLayout.CENTER);

            setSize(1200, 800);
            setLocation(500, 50);
            setVisible(true);

            break OUTTER;
         } else {
            JOptionPane.showMessageDialog(null, "패스워드가 맞지 않습니다." + "\n" + "'확인' 버튼을 누르세요.", "에러 메세지",
                  JOptionPane.ERROR_MESSAGE);

            continue OUTTER;
         }
      }
   }

   // 메뉴만들기 => 내부클래스(inner class)
   class MenuMain extends JPanel implements ActionListener, ItemListener {
      JMenuBar bar;
      JMenu file, sort, help;
      JMenuItem fnew, fopen, fsave, fexit, proinfo;
      JCheckBoxMenuItem sno, sname, schul, sjob;

      FileDialog readOpen, saveOpen;
      String fileDir, fileName, savefileName, readjileName;

      ButtonGroup gr = new ButtonGroup();// 정렬을 하나만 하기위해 버튼으로 그룹화 시킴?

      public MenuMain() {// 생성자에 객체들 만들기 화면구현(UI), 각 객체(컴포넌트)에 대한 이벤트로 연결

         bar = new JMenuBar();

         file = new JMenu("파일");
         sort = new JMenu("정렬");
         help = new JMenu("도움말");

         fopen = new JMenuItem("열기"); // JMenuItem 컴포넌트는 ActionEvent가 발생
         fsave = new JMenuItem("저장");
         fexit = new JMenuItem("닫기");

         sno = new JCheckBoxMenuItem("번호"); // JCheckBoxMenuItem 컴포넌트는 ItemEvent가 발생
         sname = new JCheckBoxMenuItem("이름");
         schul = new JCheckBoxMenuItem("지역");
         sjob = new JCheckBoxMenuItem("직업");

         proinfo = new JMenuItem("프로그램정보");

         // 객체들 컨테이너에 붙이기/.>?
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

         // 파일 메뉴 이벤트 연결
         fopen.addActionListener(this);
         fsave.addActionListener(this);
         fexit.addActionListener(this);

         // 정렬 메뉴 이벤트 연결
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

   // 입력 신상정보 즉 West 내부클래스

   class West extends JPanel { // JPanel은 작은 컨테이너 역할의 클래스

      // 내부 클래스 객체 생성
      Input input = new Input();
      Output output = new Output();

      // 생성자
      public West() {
         setLayout(new BorderLayout());
         add(input, BorderLayout.CENTER);
         add(output, BorderLayout.SOUTH);

      }

      class Input extends JPanel { // 입력 정보 담당 클래스
         JTextField[] tf = new JTextField[5];
         String[] text = { "번호", "이름", "핸드폰번호", "이메일", "주민등록번호" };
         String[] jobText = { "선택", "회사원", "공무원", "프로그래머", "교수", "학생", "기타" };
         JLabel la, job;
         JComboBox box;

         // 생성자
         public Input() { // 화면설계(UI)
            setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "입력"));
            setLayout(new GridLayout(6, 2, 5, 30));

            for (int i = 0; i < text.length; i++) {
               la = new JLabel(text[i]);
               tf[i] = new JTextField(10);
               la.setHorizontalAlignment(JLabel.CENTER);
               add(la);
               add(tf[i]);
            }
            box = new JComboBox(jobText);
            job = new JLabel("직업");
            job.setHorizontalAlignment(JLabel.CENTER);
            add(job);
            add(box);
            setPreferredSize(new Dimension(340, 300));
         }
      }
   }

   class Output extends JPanel implements ActionListener {// 신상정보 담당 클래스
      // 추가
      JPanel info = new JPanel(); // 신상정보 Border 만들기 JPanel
      JPanel search = new JPanel(); // 정보 검색 JPanel

      CardLayout card = new CardLayout();
      String[] text = { "   나이: ", "   성별: ", "   출생지역: ", "   생일: " };
      JLabel[] label = new JLabel[4];
      ButtonGroup group = new ButtonGroup();
      JRadioButton[] searchRadio = new JRadioButton[4];
      JButton searchButton;
      JButton exitButton;
      JTextField nameText;
      String[] search_name = { "이름", "직업", "출생지역", "생일" };
      int searchType;

      // 생성자
      public Output() {
         // 생성자에 객체들 만들기 화면구현(UI), 각 객체(컴포넌트)에 대한 이벤트로 연결
         // 신상정보 UI 만들기
         info.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "신상 정보"));
         info.setLayout(new GridLayout(4, 1));

         for (int i = 0; i < text.length; i++) {
            label[i] = new JLabel(text[i], JLabel.LEFT);
            info.add(label[i]);

         }
         // 정보검색 UI Border 만들기
         search.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 2), "정보 검색"));

         nameText = new JTextField(10);
         searchButton = new JButton("찾기");
         exitButton = new JButton("나가기");

         searchButton.setBackground(Color.CYAN);
         exitButton.setBackground(Color.LIGHT_GRAY);

         // 버튼 객체에 이벤트 핸들러 리스너 등록 (연결 시키기)
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

            // 이벤트 연결
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

         add(info, "신상정보 카드");
         add(search, "정보검색 카드");
      }

      @Override // 재정의
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("나가기"))
            goOut();
      }

      // 나가기 이벤트 처리 메소드
      public void goOut() {
         west.output.card.show(west.output, "신상정보 카드");

      }// 신상 정보 담당 클래스
         // 추가 버튼 클릭 시 이벤트 처리 메소드

   } // end west class

// 버튼 만들기 내부 클래스
   class Buttons extends JPanel implements ActionListener {
      Vector<String> vector;
      JButton addBtn, delBtn, preBtn, nextBtn, updateBtn, searchBtn;
      int age;
      String juminNo, sung, chul;

      // 생성자
      public Buttons() {
         setLayout(new GridLayout(1, 6));

         addBtn = new JButton("추가");
         delBtn = new JButton("삭제");
         preBtn = new JButton("이전");
         nextBtn = new JButton("다음");
         updateBtn = new JButton("수정");
         searchBtn = new JButton("검색");

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

         // 이벤트 연결 (추가 버튼에 대한)
         addBtn.addActionListener(this);
         delBtn.addActionListener(this);
         preBtn.addActionListener(this);
         nextBtn.addActionListener(this);
         updateBtn.addActionListener(this);
         searchBtn.addActionListener(this);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("추가"))
            addDate(); // 사용자가 추가버튼을 클릭했다면? addDate 메소드 호출
         else if (e.getActionCommand().equals("검색"))
            searchDate();
      }

      // 추가 버튼 클릭시 이벤트 처리 메소드 -> 가장 중요한 메소드
      public void addDate() {
         nextBtn.setEnabled(true); //다음 버튼 활성화 
         vector = new Vector<String>();
         vector.add(west.input.tf[0].getText()); //번호 입력 값 얻어서 벡터 객체에 추가 
         vector.add(west.input.tf[1].getText());
         vector.add(west.input.tf[2].getText());
         vector.add(west.input.tf[3].getText());
         
         juminNo = west.input.tf[4].getText();// 입력 받은 주민번호를 정상인지 체크하자
         
         int sum = 0;
         int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5};
         int temp = 0; 
         int result = 0;
         
         String regex = "^[0-9]{6}-[1234][0-9]{6}$";//주민번호 정규표현식 뒷 자리 첫번째는 1-4까지만 숫자가 올 수 있음. 
         
         boolean check = juminNo.matches(regex);
         
         if(check == false) {
            JOptionPane.showMessageDialog(null, "주민번호가 정규식 패턴에 맞지 많습니다."+"\n"+"주민번호를 다시 입력하세요.",
                  "에러 메세지", JOptionPane.ERROR_MESSAGE);
            
            west.input.tf[4].setText(null);
            west.input.tf[4].requestFocus();
            return; //현 상태를 그대로 유지해라 
            
         }else if(juminNo.length() == 14) {
            
            //1단계 적용 sum 구하기 
            for (int i=0; i<13; i++) {
               if(juminNo.charAt(i)=='-') continue;
               sum += (juminNo.charAt(i)-48)*weight[i];
                                             
            }
            //2단계 적용하기 
            temp = 11 -(sum % 11);
         
            //3단계 적용하기  
            result = temp%10;
         }
         //주민번호 정상 유무 체크 
         if(result == juminNo.charAt(13)-48) {
            JOptionPane.showMessageDialog(null,
                  "주민번호 체크 결과 정상입니다."+"\n" + "'확인' 버튼을 누루면 정보가 출력 됩니다.");
            vector.add(juminNo);
            
            Calendar cal = Calendar.getInstance(Locale.KOREA);
            int year = cal.get(Calendar.YEAR); //2021 얻어옴
            
            int yy = Integer.parseInt(juminNo.substring(0, 2));
            
            if((juminNo.charAt(7)-48) < 3) { 
               yy = yy + 1900 ;
            }else {
               yy = yy + 2000; 
            }
             
            int age = year - yy + 1; 
         
            //성별 추출하기 
            if((juminNo.charAt(7)-48) % 2 == 0) { 
               sung = "여자";
            } else{ 
               sung = "남자";
            }
         
            String[][]localCode = {{"서울","00","08"},{"부산","09","12"},{"인천","13","15"},{"경기","16","25"},{"강원","26","34"},
                              {"충북","35","39"},{"대전","40","40"},{"충남","41","43"},{"충남","45","47"},{"세종","44","44"},{"세종","96","96"},
                              {"전북","48","54"},{"전남","55","64"},{"광주","65","65"},{"대구","67","70"},{"경북","71","80"},{"경남","81","84"},
                              {"경남","86","90"},{"울산","85","85"},{"제주","91","95"}
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
            vector.add(juminNo.substring(2,4)+"월" + juminNo.substring(4, 6)+"일");
            
            west.output.label[0].setText("   나이: " + "   " + String.valueOf(age));
            west.output.label[1].setText("   성별: " + "   " + sung);
            west.output.label[2].setText("   출생 지역: " + "   " + place);
            west.output.label[3].setText("   나이: " + "   " + 
                     juminNo.substring(2,4)+"월" + juminNo.substring(4, 6)+"일");
            
            vector.add(west.input.box.getSelectedItem().toString());
            
            west.input.tf[0].setText(null);    //번호
            west.input.tf[1].setText(null);      //이름
            west.input.tf[2].setText(null);      //핸폰
            west.input.tf[3].setText(null);    //이메일
            west.input.tf[4].setText(null);      //주민번호
            west.input.box.setSelectedIndex(0);   //콤보박스 객체 선택으로 다시 돌려놓기 
            west.input.tf[0].requestFocus(); //번호에 포커스 맞추기 
            
            showTable.data.addElement(vector);
            showTable.datamodel.fireTableDataChanged();
         }else {
            JOptionPane.showMessageDialog(null, "주민번호가 틀림",
                  "에러 메세지", JOptionPane.ERROR_MESSAGE);
            west.input.tf[4].setText(null);
            west.input.tf[4].requestFocus();
            return;
         }
      }
         
      public void searchDate() {
         west.output.card.show(west.output, "정보검색 카드");
      }
   }// end buttons 클래스

   // 센터 JTable 만들기 => 내부클래스
   class ShowTable extends MouseAdapter {

      DefaultTableModel datamodel;
      JTable table;
      JScrollPane scrollPane;

      String[] colName = { "번호", "이름", "핸드폰번호", "이메일", "주민번호", "나이", "성별", "출생지역", "생일", "직업" };

      Vector<Vector<String>> data; // [중요]
      Vector<String> column_name;
      int row = -1;

      // 생성자
      public ShowTable() {
         data = new Vector<Vector<String>>();
         column_name = new Vector<String>();

         for (int i = 0; i < colName.length; i++) {
            column_name.add(colName[i]);
         }
         // 1단계
         datamodel = new DefaultTableModel(data, column_name) {
            public boolean isCellEditable(int row, int column) {
               return false;
            }

         };
         // 2단계
         table = new JTable(datamodel);

         // 3단계
         scrollPane = new JScrollPane(table);

         // 이벤트 연결
         table.addMouseListener(this);
         table.setAutoCreateRowSorter(true);

         TableRowSorter<TableModel> tablesorter = new TableRowSorter<TableModel>(table.getModel());

         table.setRowSorter(tablesorter);
         TableSize();

      }

      public void TableSize() { // J 테이블 셀 키긔 조절하기
         table.getColumnModel().getColumn(0).setPreferredWidth(50); // 번호
         table.getColumnModel().getColumn(1).setPreferredWidth(50);
         table.getColumnModel().getColumn(2).setPreferredWidth(120);
         table.getColumnModel().getColumn(3).setPreferredWidth(150);
         table.getColumnModel().getColumn(4).setPreferredWidth(130);
         table.getColumnModel().getColumn(5).setPreferredWidth(50);
         table.getColumnModel().getColumn(6).setPreferredWidth(50);
         table.getColumnModel().getColumn(7).setPreferredWidth(80);
         table.getColumnModel().getColumn(8).setPreferredWidth(70);
         table.getColumnModel().getColumn(9).setPreferredWidth(50);// 직업

      }
   }

   public static void main(String[] args) {
      // 생성
      ManageSystem2 ms = new ManageSystem2();
   }
}