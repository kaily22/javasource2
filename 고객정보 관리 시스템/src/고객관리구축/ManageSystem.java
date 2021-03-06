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
 * 
 * << 개정이력(Modification Information) >>
 *  수정일                   수정자          작업 및 수정 내용
 *  ------       -------   -------------------
 *  2021.10.07    이승현          레이아웃 설계,기능 구현
 * 
 */


//외부 클래스
public class ManageSystem extends JFrame  { //JFrame 클래스는 최상위 컨테이너 역할의 클래스이다.

	public static final String String = null;
	
	//내부 클래스 객체 생성(모든 내부클래스에서 접근 가능->global(전역)-> 클래스 객체간의 상호작용 발생)
	MenuMain menu = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	showTable showtable = new showTable();

	
	//외부 클래스 => 생성자
	public ManageSystem() {
		OUTTER: while(true) { //OUTER: -> 자바에서:label
			ImageIcon icon = new ImageIcon("src/images/customer_image.JPG");
			JOptionPane.showMessageDialog(null, null, "고객정보관리시스템",
					                       JOptionPane.NO_OPTION, icon);
			//NO_OPTION : '아니오'는 X
			
			//showInputDialog로 password 받기
			String password = JOptionPane.showInputDialog("고객관리시스템" +"\n"+"패스워드 입력");
			//실제 패스워드
			String passwd = "king12345";
			
			if(password == null) {
				break OUTTER;
			}
			else if(password.equals(passwd)) { //패스워드 인증 처리 성공 시 => 실행화면 띄우기
				setTitle("고객정보 관리 시스템");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//추가
			    add(menu.bar, BorderLayout.NORTH);
			    add(west,BorderLayout.WEST);
			    add(buttons, BorderLayout.SOUTH);
			    add(showtable.scrollPane, BorderLayout.CENTER);
			    
				
				setSize(1200,800);
				setLocation(500, 50);
				setVisible(true);
			
				break OUTTER;
				
			}else {
				JOptionPane.showMessageDialog(null, "패스워드가 맞지 않습니다." +"\n"+"'확인' 버튼 누르세요.",
						                     "에러 메시지",JOptionPane.ERROR_MESSAGE);
				
				continue OUTTER;
			}
			
		}
	}
	
	//메뉴 만들기 => 내부 클래스(inner class)
	class MenuMain extends JPanel implements ActionListener, ItemListener{

		JMenuBar bar;
		JMenu file, sort, help;
		JMenuItem fnew, fopen, fexit, proinfo,fsave;
		JCheckBoxMenuItem sno, sname, schul, sjob;
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, savefileName,readjileName;
		ButtonGroup gr = new ButtonGroup();
		
		
		//생성자
		public MenuMain() {  //화면구현(UI 설계 뿐 만 아니라 객체에 대한 이벤트 연결)
			
			bar = new JMenuBar();
			
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			
			fopen = new JMenuItem("열기"); //JMenuItem 컴퍼넌트는 ActionEvent가 발생
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			
			sno = new JCheckBoxMenuItem("번호"); //JCheckBoxMenuItem 컴퍼넌트는 ItemEvent가 발생
			sname = new JCheckBoxMenuItem("이름");
			schul = new JCheckBoxMenuItem("출신지역");
			sjob = new JCheckBoxMenuItem("직업");
			
			proinfo = new JMenuItem("프로그램 정보");
					
			//객체를 컨테이너에 붙이기
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
			
			//파일 메뉴 이벤트 연결
			fopen.addActionListener(this); //this는 이벤트 헨들러 리스너 객체
			fsave.addActionListener(this);
			fexit.addActionListener(this);
			
			//정렬 메뉴 이벤트 연결
			sno.addItemListener(this);
			sname.addItemListener(this);
			schul.addItemListener(this);
			sjob.addItemListener(this);
			
		}		
		
		//ItemListener
		@Override
		public void itemStateChanged(ItemEvent e) {
			
		}

		
		//actionListener 메소드
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	} //end MenuMain 클래스 =============================================================
	
	
	//입력, 신상정보 즉 West => 내부 클래스
	//JFrame : 큰 컨테이너 JPanel : 작은 컨테이너
	class West extends JPanel {
		
		//내부 클래스 객체 생성
		Input input = new Input();
		Output output = new Output();		
		
		//생성자
		public West() {
			setLayout(new BorderLayout());
			add(input,BorderLayout.CENTER);
			add(output, BorderLayout.SOUTH);
		}
		
		//입력을 담당하는 클래스
		class Input extends JPanel { //입력 정보 담당 클래스
			
			JTextField[] tf = new JTextField[5];
			String[] text = {"번호","이름","핸드폰번호","이메일","주민등록번호"};
			String[] jobText = {"선택","회사원","공무원","프로그래머","교수","학생","기타"};
			JLabel la, job;
			JComboBox box;
			
			//생성자
			public Input() { //화면 설계(UI)
				
				setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"입력"));
				setLayout(new GridLayout(6, 2, 5, 30));
				
				for(int i=0; i<text.length; i++) {
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
				setPreferredSize(new Dimension(340,300));
				
			}
		}
		
		class Output extends JPanel implements ActionListener {  //신상정보 담당 클래스
			
			//추가
			JPanel info = new JPanel(); //'신상 정보' 보더 만들기 JPanel
			JPanel search = new JPanel(); // '정보 검색' 보더 만들기 JPanel
			
			
			CardLayout card = new CardLayout();
			String[] text = {"     나이 : ", "    성별: ","    출생지역 : ","    생일: "};
			JLabel[] label = new JLabel[4];
			ButtonGroup group = new ButtonGroup();
			JRadioButton[] searchRadio = new JRadioButton[4];
 			JButton searchButton;
 			JButton exitButton;
 			JTextField nameText;
 			String[] search_name = {"이름","직업","출생지역","생년월일"};
 			int searchType;
			
			//생성자
			public Output() {
				
				//'신상정보' UI 보더 만들기
				info.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"신상정보"));
				info.setLayout(new GridLayout(4,1));
				
				for(int i=0; i<text.length;i++) {
				  label[i] = new JLabel(text[i],JLabel.LEFT);
				  info.add(label[i]);
				}
				
				//'정보검색' UI 보더 만들기
				search.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"신상정보"));
				
				nameText = new JTextField(10);
				searchButton = new JButton("찾기");
				exitButton = new JButton("나가기");
				
				searchButton.setBackground(Color.CYAN);
				exitButton.setBackground(Color.LIGHT_GRAY);
				
				//버튼 객체에 이벤트 헨들러 리스너 등록
				searchButton.addActionListener(this);
				exitButton.addActionListener(this);
				
				setPreferredSize(new Dimension(340,300));
				
				int x = -70;
				search.setLayout(null);
				
				for(int i=0; i<searchRadio.length; i++) {
					searchRadio[i] = new JRadioButton(search_name[i]);
					searchRadio[i].setBounds(x+=80,60,80,30);
					group.add(searchRadio[i]);
					search.add(searchRadio[i]);
					//이벤트 연결
					searchRadio[i].addActionListener(this);
				}
				
				nameText.setBounds(40,110,200,30);
				searchButton.setBounds(35,170,80,30);
				exitButton.setBounds(140,170,110,30);
				search.add(nameText);
				search.add(searchButton);
				search.add(exitButton);
				
				card = new CardLayout();
				setLayout(card);
				
				add(info,"신상정보카드");
				add(search, "정보검색카드");
				
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("나가기")) goOut(); 
			} 
			
			
			//'나가기'이벤트 처리 메소드
			public void goOut() {
				west.output.card.show(west.output, "신상정보카드");
				
			}
			
		}
		
	}
	
	//end West 클래스 =====================================================================
	
	
	class Buttons extends JPanel implements ActionListener {
		
		//객체 참조 변수를 전역변수 개념으로 다 선언해준다.
		Vector<String> vector;
		JButton addBtn, delBtn, preBtn, nextBtn, updateBtn, searchBtn;
		int age;
		String juminNo, sung, chul;
		
		//생성자
		public Buttons() {
			setLayout(new GridLayout(1,6));
			
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
			
			
			//이벤트 연결
			addBtn.addActionListener(this);
			delBtn.addActionListener(this);
			preBtn.addActionListener(this);
			nextBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			searchBtn.addActionListener(this);
			
		}

		@Override //자식 클래스에 맞게끔 재정의해서 사용
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("추가")) addData(); 
			else if(e.getActionCommand().equals("검색")) searchData();
			
		}
		
		//'추가' 버튼 클릭 시 이벤트 처리 메소드 => 가장 중요한 메소드
		public void addData() {
			
			nextBtn.setEnabled(true); //'다음'버튼 활성화
			vector = new Vector<String>();
			vector.add(west.input.tf[0].getText()); //입력받은 번호 얻어서 추가시키기
			vector.add(west.input.tf[1].getText()); //이름
			vector.add(west.input.tf[2].getText()); //헨드폰번호
			vector.add(west.input.tf[3].getText()); //이메일
			
			//String객체에 할당시키기
			juminNo = west.input.tf[4].getText(); //입력 받은 주민번호를 정상인지 체크하자!
//			vector.add(west.input.tf[4].getText()); //주민번호

			
			int  sum = 0; //누계 변수는 0으로 초기화
			int[] weight = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};
			int temp =0;
			int result = 0;
			
			// 주민번호 정규표현식
			String regex = "^[0-9]{6}-[1234][0-9]{6}$";

			// 주민번호를 regex로 matches로 반환 타입 boolean

//			1. boolean check = Pattern.matches(regex, juminNum);

			// 2번째 : String 클래스에서 matches 메소드
			boolean check = juminNo.matches(regex);

			if (check == false) {
				JOptionPane.showMessageDialog(null,"주민번호가 정규식 패턴에 맞지 않음" +"\n"+"주민번호를 다시 입력하세요"
			                                  ,"에러 메세지",JOptionPane.ERROR_MESSAGE);
				
				west.input.tf[4].setText(null);
				west.input.tf[4].requestFocus();
				return;  //현 상태를 그대로 유지하라!
			
			}else if(juminNo.length() == 14) {
				
				// 유효성 검사 1단계 => sum 구하기
				for (int i = 0; i < 13; i++) {
					// 한문자만 가져오기
					if (juminNo.charAt(i) == '-')
						continue;
					sum += (juminNo.charAt(i) - 48) * weight[i];
				}
//			   System.out.println(sum);

				// 2단계 -> temp 값이 두 자리인 경우가 있다.
				temp = 11 - (sum % 11);

				// 3단계 공식 => temp 값이 두자리인 주민번호를 대비해서...
				result = temp % 10;
			}
				// 주민번호 정상 유무 체크
				if (result == juminNo.charAt(13) - 48) {
					JOptionPane.showMessageDialog(null, "주민번호 체크 결과가 정상입니다." + "\n" +"확인 '버튼을 누르면 정보가 출력됩니다.");
					
					
					vector.add(juminNo);
					
					//나이 추출
					Calendar cal = Calendar.getInstance(Locale.KOREA);
					int year = cal.get(Calendar.YEAR); // 2021 얻어옴
					
					int yy = Integer.parseInt(juminNo.substring(0, 2));
					
					if (juminNo.charAt(7) - 48 < 3) { // 1,2인 경우
						yy = yy + 1900; // 97+1900 = 1997
					} else {
						yy = yy + 2000;
					}
					int age = year - yy + 1; // 본 나이

					// 성별 추출
					if ((juminNo.charAt(7) - 48) % 2 == 0) {
						sung = "여자";
					} else {
						sung = "남자";
					}

					// 지역추출

					String[][] localCode = { {"서울", "00", "08" }, { "부산", "09", "12" }, 
							               { "인천", "13", "15" }, { "경기", "16", "25" }, 
							               { "강원", "26", "34" }, { "충북", "35", "39" }, 
							               { "대전", "40", "40" }, { "충남", "41", "43"}, 
							               { "충남", "45", "47" }, {"세종", "44", "44" }, 
							               { "세종", "96", "96" }, { "전북", "48", "54" }, 
							               { "전남", "55", "64" }, { "광주", "65", "66" }, 
							               { "대구", "67", "70" }, { "경북", "71", "80" }, 
							               {"경남", "81", "84"  },  { "경남", "86", "90" }, 
							               { "울산", "85", "85" }, { "제주", "91", "95" }};

					String localeString = juminNo.substring(8,10);
					int locale = Integer.parseInt(localeString);
					String birthPlace = null;

					for (int j = 0; j < 19; j++) {
						if (locale >= Integer.parseInt(localCode[j][1]) && locale <= Integer.parseInt(localCode[j][2])) {
							birthPlace = localCode[j][0];
						}
					}
					
					vector.add(String.valueOf(age));
					vector.add(sung);
					vector.add(birthPlace);
					vector.add(juminNo.substring(2, 4)+"월"+juminNo.substring(4, 6)+"일");
					
					
					west.output.label[0].setText("    나이 : " + String.valueOf(age));
					west.output.label[1].setText("    성별 : " + sung);
					west.output.label[2].setText("    출생지역 : " + birthPlace);
					west.output.label[3].setText("    나이 : " +"  "+ juminNo.substring(2,4)+"월" + juminNo.substring(4,6)+"일");
					
					//west객체가 가장 큼
					vector.add(west.input.box.getSelectedItem().toString());
					
					west.input.tf[0].setText(null); //번호
					west.input.tf[1].setText(null); //이름
					west.input.tf[2].setText(null); //핸드폰번호
					west.input.tf[3].setText(null); //이메일
					west.input.tf[4].setText(null); //주민번호
					west.input.box.setSelectedIndex(0); //콤보박스 객체에 '선택'으로 원위치
					west.input.tf[0].requestFocus(); //번호에 포커스를 맞춰라
					
					
					showtable.data.addElement(vector);
					showtable.datamodel.fireTableDataChanged();
							
				}else {
					JOptionPane.showMessageDialog(null, "주민번호 틀림", "에러 메시지", JOptionPane.ERROR_MESSAGE);
					west.input.tf[4].setText(null);
					west.input.tf[4].requestFocus();
					return; 
				}
			
			}
			

		//'추가' 버튼 클릭 시 이벤트 처리 메소드
		public void searchData() {
			west.output.card.show(west.output, "정보검색카드");
		}
		}
	
	
	//end Buttons 클래스 ====================================================================
	
	//센터쪽 => JTable 만들기 => 내부 클래스
	
	class showTable extends MouseAdapter {
		
		DefaultTableModel datamodel;
		JTable table;
		JScrollPane scrollPane;
		
		
		String[] colName= {"번호","이름","핸드폰번호","이메일","주민번호","나이","성별","출생지역","생일","직업"};
		
		
		Vector<Vector<String>> data; //백터라는 가변배열에 vector가 들어감 [중요]
		Vector<String> column_name;
		int row = -1;
		
		//생성자
		public showTable(){
			
			//가변배열 Vector 객체
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0; i<colName.length; i++) {
				column_name.add(colName[i]);
			}
			
			//1단계
			datamodel = new DefaultTableModel(data, column_name) {
				public boolean isCelleditable(int row, int column) {
					return false;
				}
			};
			
			//2단계 
			table = new JTable(datamodel);
			
			//3단계
			scrollPane = new JScrollPane(table);
			
			//이벤트 연결
			table.addMouseListener(this);
			table.setAutoCreateRowSorter(true);
			
			
			TableRowSorter<TableModel> tablesorter = new TableRowSorter<TableModel>(table.getModel());
			
			table.setRowSorter(tablesorter);
			TableSize();
		}
		
		public void TableSize() {
			
			//JTable의 셀 크기 조절하기
			table.getColumnModel().getColumn(0).setPreferredWidth(50); //'번호'셸
			table.getColumnModel().getColumn(1).setPreferredWidth(50); //'이름'셸
			table.getColumnModel().getColumn(2).setPreferredWidth(120); //'핸펀'셸
			table.getColumnModel().getColumn(3).setPreferredWidth(150); //'이메일'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(130); //'주민번호'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(50); //'나이'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(50); //'성별'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(80); //'출생지역'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(70); //'생일'셸
			table.getColumnModel().getColumn(4).setPreferredWidth(50); //'직업'셸
			
		  }
		
		}
	

	public static void main(String[] args) {
		
	ManageSystem ms = new ManageSystem();
	
	}	
	
	
}
