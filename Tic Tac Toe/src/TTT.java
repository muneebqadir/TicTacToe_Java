import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class TTT extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int count=1,playerCheckValue=0,set_positionValue=10,cpuCheckValue=0,ifdoit=0,playerScore=0,cpuScore=0,checkWinnerValue=0,checkWinnerPlayer=0;
	static int checkWinnerCpu=0,vsCpu=1,Player1Cross=1,crossSwap=1,crissSwap=0;
	boolean user_first=true;


	static char pos[]={'a','b','c','d','e','f','g','h','i'},flag='j',search='n',player_move='j',player_move1='j',doItValue='j',randomValue='j',tempd='j';
	
	// pos is my grid.
    /*      a | b | c
     *      d | e | f
     *      g | h | i
     */
	
	String Player1Name="Muneeb",Player2Name="CPU";	
	
	// importing all images into image icons
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	ImageIcon criss=new ImageIcon("blackO2.jpg");
	ImageIcon cross=new ImageIcon("redX2.jpg");
	ImageIcon ttt2=new ImageIcon("ttt2.jpg");
	ImageIcon ttt7=new ImageIcon("ttt7.jpg");
	ImageIcon ttt=new ImageIcon("ttt.jpg");
	ImageIcon icon = new ImageIcon("src/download.png");

	// Menu bar in GUI
	JMenuBar mb=new JMenuBar();
	JMenu menuA=new JMenu("Game");
	
	
	// Play Computer first or User First inside menu
	JRadioButtonMenuItem rbMenuItem1=new JRadioButtonMenuItem("Player First",true); // true for comp
	JRadioButtonMenuItem rbMenuItem2=new JRadioButtonMenuItem("Computer First");
	
	// Declaring Button Group for first choice
		ButtonGroup bg=new ButtonGroup();
	
	//Players symbol 
	JMenu subMenu=new JMenu("Player Symbol");
	JRadioButtonMenuItem rbMenuItem3=new JRadioButtonMenuItem("Cross",true);	// true for X
	JRadioButtonMenuItem rbMenuItem4=new JRadioButtonMenuItem("Criss");
	
	//Declaring button group for criss / cross 
	ButtonGroup bg1=new ButtonGroup();
	
	
	// 9 J buttons one for each box
	JButton b1=new JButton();
	JButton b2=new JButton();
	JButton b3=new JButton();
	JButton b4=new JButton();
	JButton b5=new JButton();
	JButton b6=new JButton();
	JButton b7=new JButton();
	JButton b8=new JButton();
	JButton b9=new JButton();
	
	// for dialog box when game has ended
	JButton button1 = new JButton("Yes, Please"); 
	JButton button2 = new JButton("No, thanks"); 
	JButton button3 = new JButton("Done");

	
	// new panels for the frame
	JPanel p=new JPanel();
	JPanel p1=new JPanel();

	// Labels for GUI
	JLabel l=new JLabel("SCORE");
	JLabel l1=new JLabel(Player1Name+": 0");
	JLabel l2=new JLabel(Player2Name+": 0");
	JLabel l3=new JLabel("");
	JLabel l4=new JLabel(ttt2);	// image for background
	
	// text fields
	JTextField tf1 =new JTextField("PLAYER 1",20);
	JTextField tf2 =new JTextField("CPU",20);
	
	// Dialogs for code 
	// D IS WIN / LOSE DIALOG
	JDialog d;
	//JDialog d1;
	
	// Setting up a constructor frame
	TTT()
	{

		this.setLocation(dim.width/8-this.getSize().width/2, dim.height/20-this.getSize().height/2);
		setLayout(null);
		// APPLICATION image sett ttt
		setIconImage(ttt.getImage());
		// Not Resizeable
		setResizable(false);
		// calling mb now 
		setJMenuBar(mb);
		
		// pannel p is null
		p.setLayout(null);
		// set pannal p1 as a grid 3x3
		p1.setLayout(new GridLayout(3,3));
		
		// adding option for user/computer first to buttons
		bg.add(rbMenuItem1);
		bg.add(rbMenuItem2);
		
		// option for X or O to button group
		bg1.add(rbMenuItem3);
		bg1.add(rbMenuItem4);
		
	
		//adding option  to menu on gui
		menuA.add(rbMenuItem1);
		menuA.add(rbMenuItem2);
		menuA.addSeparator();
		
		// adding sub menu items and submenu on menu on gui
		menuA.add(subMenu);
		// what is this?
		subMenu.setToolTipText("In \"aginst human\" mode it will be assigned to first Player");
		subMenu.add(rbMenuItem3);
		subMenu.add(rbMenuItem4);
		
		// Adding menu A to menu  bar 
		mb.add(menuA);

		//TO be pressed with alt
		menuA.setMnemonic('G');
		
		
		
		
		// adding labels Score,pllayer names
		add(p);
		p.add(l);
		p.add(l1);
		p.add(l2);
		
		// adding pannel p1 on pannel p
		p.add(p1);
		
		// adding l4 which is the image and l3 (empty string)
		p.add(l3);
		p.add(l4);
		
		// adding 9 buttons on panal p1 in grid
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		
		// p window size
		p.setBounds(0,0,1000,500);
		// p1(buttons size)
		p1.setBounds(366,200,287,130);
		//labels size
		l.setBounds(480,0,100,25);
		l1.setBounds(8,35,100,25);
		l2.setBounds(910,35,100,25);
		l3.setBounds(420,420,500,25);
		// image size
		l4.setBounds(0,0,1000,420);
		

	
		
		//Adding action listener to whole buttons grid
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		// adding action listener to dialog buttons and menu buttons
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		rbMenuItem1.addActionListener(this);
		rbMenuItem2.addActionListener(this);
		rbMenuItem3.addActionListener(this);
		rbMenuItem4.addActionListener(this);
	}
	
	public void set_count()
	{
		if (user_first==false)
		{
			count=2;
		}
	}
	
	// method that creates random characters from a to j to put in grid
	public void random()
	{
		Random rand = new Random();
		// 106-97 + 97
		// TO cast char a to j from ascii
		int randomNum = rand.nextInt(9)+ 97;// check above comment
		char search='n',tempe;
		tempe=(char)randomNum;
		for(int h=0;h<9;h++)
		{
			if(tempe==pos[h])
			{
				search=tempe;
			}
		}
		if(search==tempe)
		{
			randomValue=tempe;
		}
		else
		{	
			random();	
		}
	}
	
	// if any of these logical statements are correct cpuCheckValue will be equal to 1 ( if cpu can win/draw)
	public void cpuCheck()
	{
		char tempe='w';
		if (pos[1]==pos[2]||pos[3]==pos[6]||pos[4]==pos[8])
		tempe='a';
		else if (pos[0]==pos[2]||pos[4]==pos[7])
		tempe='b';
		else if (pos[0]==pos[1]||pos[5]==pos[8]||pos[4]==pos[6])
		tempe='c';
		else if (pos[4]==pos[5]||pos[0]==pos[6])
		tempe='d';
		else if (pos[3]==pos[5]||pos[1]==pos[7]||pos[0]==pos[8]||pos[2]==pos[6])
		tempe='e';
		else if (pos[3]==pos[4]||pos[2]==pos[8])
		tempe='f';
		else if (pos[7]==pos[8]||pos[0]==pos[3]||pos[2]==pos[4])
		tempe='g';
		else if (pos[6]==pos[8]||pos[1]==pos[4])
		tempe='h';
		else if (pos[6]==pos[7]||pos[2]==pos[5]||pos[0]==pos[4])
		tempe='i';
		for(int h=0;h<9;h++)
		{
			if(tempe!='w')
			{
				cpuCheckValue=1;
			}
		}
}

	// method checking all the senarios and setting ifdoit=1 if senario =true and doitValue to a-i
	public void doit()
	{
		

		v:
		{
		// senario in which comp will win by setting pos[a]
		if (pos[1]==pos[2]&&pos[2]=='O'||pos[3]==pos[6]&&pos[6]=='O'||pos[4]==pos[8]&&pos[8]=='O')
		{
		tempd='a';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		
		}
		//senario in which comp will win by setting pos[b]
		if (pos[0]==pos[2]&&pos[2]=='O'||pos[4]==pos[7]&&pos[7]=='O')
		{
		tempd='b';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[c]
		if (pos[0]==pos[1]&&pos[1]=='O'||pos[5]==pos[8]&&pos[8]=='O'||pos[4]==pos[6]&&pos[6]=='O')
		{
		tempd='c';
		for(int h=0;h<9;h++)
						{
							if(tempd==pos[h])
							{
								break v;
							}
						}
		}
		//senario in which comp will win by setting pos[d]
		if (pos[4]==pos[5]&&pos[5]=='O'||pos[0]==pos[6]&&pos[6]=='O')
		{
		tempd='d';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[e]
		if (pos[3]==pos[5]&&pos[5]=='O'||pos[1]==pos[7]&&pos[7]=='O'||pos[0]==pos[8]&&pos[8]=='O'||pos[2]==pos[6]&&pos[6]=='O')
		{
		tempd='e';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[f]
		if (pos[3]==pos[4]&&pos[4]=='O'||pos[2]==pos[8]&&pos[8]=='O')
		{
		tempd='f';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[g]
		if (pos[7]==pos[8]&&pos[8]=='O'||pos[0]==pos[3]&&pos[3]=='O'||pos[2]==pos[4]&&pos[4]=='O')
		{
		tempd='g';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[h]
		if (pos[6]==pos[8]&&pos[8]=='O'||pos[1]==pos[4]&&pos[4]=='O')
		{
		tempd='h';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will win by setting pos[i]
		if (pos[6]==pos[7]&&pos[7]=='O'||pos[2]==pos[5]&&pos[5]=='O'||pos[0]==pos[4]&&pos[4]=='O')
		{
		tempd='i';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[a]
		if (pos[1]==pos[2]||pos[3]==pos[6]||pos[4]==pos[8])
		{
		tempd='a';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[b]
		if (pos[0]==pos[2]||pos[4]==pos[7])
		{
		tempd='b';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[c]
		if (pos[0]==pos[1]||pos[5]==pos[8]||pos[4]==pos[6])
		{
		tempd='c';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[d]
		if (pos[4]==pos[5]||pos[0]==pos[6])
		{
		tempd='d';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[e]
		if (pos[3]==pos[5]||pos[1]==pos[7]||pos[0]==pos[8]||pos[2]==pos[6])
		{
		tempd='e';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[f]
		if (pos[3]==pos[4]||pos[2]==pos[8])
		{
		tempd='f';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[g]
		if (pos[7]==pos[8]||pos[0]==pos[3]||pos[2]==pos[4])
		{
		tempd='g';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[h]
		if (pos[6]==pos[8]||pos[1]==pos[4])
		{
		tempd='h';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		//senario in which comp will draw by setting pos[i]
		if (pos[6]==pos[7]||pos[2]==pos[5]||pos[0]==pos[4])
		{
		tempd='i';
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							break v;
						}
					}
		}
		
		}
			// if senario is a-i then ifdoit=1
		for(int h=0;h<9;h++)
					{
						if(tempd==pos[h])
						{
							ifdoit=1;
							doItValue=tempd;
						}
					}
	}
	
	
	public void cpuMove()
	{
		//first running cpuCheck to see if comp can draw or win 
		int tempe;
		cpuCheck();
		tempe=cpuCheckValue;
		if(tempe==1)
		{
			doit();
			flag=doItValue;
			
		}
		//System.out.println( user_first+ " and count   "+ count );
		if(user_first==false&&count==2)
		{
			random();
			flag=randomValue;
			
			
		}
		// if this is the first computer move and player has put a X in any corner then flag middle box (e)
		if(count==2&&(player_move=='a'||player_move=='c'||player_move=='g'||player_move=='i'))
		{
			flag='e';
		}
		// if this is the first computer move and user has put a X in middle then do flag either a ,c,g,i randomly
		else if(count==2&&player_move=='e')
		{
			do 
			{
				random();
				flag=randomValue;
			}
			while(flag=='b'||flag=='d'||flag=='e'||flag=='f'||flag=='h');
		}
		
		// if this is the 4th move (2nd comp move) and there is no blocking/winning and player did a , c , g or i then randomly pick between B,D,E,F,H
		else if(count==4&&ifdoit!=1&&(player_move1=='a'||player_move1=='c'||player_move1=='g'||player_move1=='i'))
		{
			do 
			{
				random();
				flag=randomValue;
			}
			while(flag=='a'||flag=='c'||flag=='g'||flag=='i');
		}
		// if this is the 4th move (2nd comp move) and there is no blocking or winning and player did e then randomly choose between A,C,G,I
		else if(count==4&&ifdoit!=1&&player_move1=='e')
		{
			do 
			{
				random();
				flag=randomValue;
			}
			while(flag=='b'||flag=='d'||flag=='f'||flag=='h'||flag=='e');
		}
		// if move >1 and its not a draw and comp cant win or draw then call random function
		else if (count>1&&ifdoit!=1&&count<9)
		{
				random();
				flag=randomValue;
		}
		else if (count==10)
		{
			System.out.println("haha");
		}
		
		
		// calling set position method  

		set_position();
		pos[set_positionValue]='O';
		// reset ifdoit to 0
		ifdoit=0;
	}
	
	public void playerCheck()
	{
		for(int h=0;h<9;h++)
		{
			// if flag is a-i if not then there hasn't move
			if(flag==pos[h])
			{
				search=flag;
			}
		}
		// if search = flag (which means that the move hasnt been before there);p;
		if(search==flag)
			{
			
			
			// set search as n
				search='n';
				set_position();
				
			// checking if the move has been made here before#
				if ( pos[set_positionValue]=='X'|| pos[set_positionValue]=='O')
				{
					JOptionPane.showConfirmDialog(null, "Do you want to proceed? Are you fine? lol sorry MOVE HAS BEEN MADE HERE ALREADY", "Are you ok?",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
				}
				
				
			 //if not CPU move then set pointer X
				if(count%2!=0)
				{
					pos[set_positionValue]='X';
				}
			
				// if one move has been made 
				// first move 
				if(count==1)
				{
					player_move1=flag;
				}
				//otherwise set player_move = flag
				player_move=flag;
				playerCheckValue=1;
				}
			}
	
	// this method will take flag position and turn it to 0-8 in set_positionValue
	public void set_position()
	{
	if(flag=='a')
		set_positionValue=0;
		else if(flag=='b')
		set_positionValue=1;
		else if(flag=='c')
		set_positionValue=2;
		else if(flag=='d')
		set_positionValue=3;
		else if(flag=='e')
		set_positionValue=4;
		else if(flag=='f')
		set_positionValue=5;
		else if(flag=='g')
		set_positionValue=6;
		else if(flag=='h')
		set_positionValue=7;
		else if(flag=='i')
		set_positionValue=8;
		}
	
	public void checkWinner()
	{
		//  wins for X
	if(pos[0]=='X'&&pos[1]=='X'&&pos[2]=='X')
		{ 
		checkWinnerPlayer=1;
			l1.setText(Player1Name+": "+playerScore);
			l3.setText("Congratulations! "+Player1Name+", You win the game :).");
			checkWinnerValue=1;
		}
	else if(pos[3]=='X'&&pos[4]=='X'&&pos[5]=='X'||pos[6]=='X'&&pos[7]=='X'&&pos[8]=='X'||pos[0]=='X'&&pos[3]=='X'&&pos[6]=='X'||pos[1]=='X'&&pos[4]=='X'&&pos[7]=='X'||pos[2]=='X'&&pos[5]=='X'&&pos[8]=='X'||pos[0]=='X'&&pos[4]=='X'&&pos[8]=='X'||pos[2]=='X'&&pos[4]=='X'&&pos[6]=='X')
{ 
	checkWinnerPlayer=1;
		l1.setText(Player1Name+": "+playerScore);
		l3.setText("Congratulations! "+Player1Name+", You win the game :).");
		checkWinnerValue=1;
	}// checking wins for Os
		else if(pos[0]=='O'&&pos[1]=='O'&&pos[2]=='O'||pos[3]=='O'&&pos[4]=='O'&&pos[5]=='O'||pos[6]=='O'&&pos[7]=='O'&&pos[8]=='O'||pos[0]=='O'&&pos[3]=='O'&&pos[6]=='O'||pos[1]=='O'&&pos[4]=='O'&&pos[7]=='O'||pos[2]=='O'&&pos[5]=='O'&&pos[8]=='O'||pos[0]=='O'&&pos[4]=='O'&&pos[8]=='O'||pos[2]=='O'&&pos[4]=='O'&&pos[6]=='O')
		{
		checkWinnerCpu=1;
			l2.setText(Player2Name+": "+cpuScore);
			l3.setText("CPU win the game.");
			checkWinnerValue=1;
		}
	// if there have been more than 9 moves than draw
		else if(user_first==false&&count==10)
		{
		l3.setText("Game draw.");
			checkWinnerValue=1;
		}
		else if (user_first==true&&count==11)
		{
			l3.setText("Game draw.");
			checkWinnerValue=1;
		}
	}
	// designing dialogs
	public void dialogs()
	{
		//System look-and-feel on Windows retains the borders you would expect them of a native window, e.g. staying clear of the taskbar in Windows.
	JDialog.setDefaultLookAndFeelDecorated(true);
		d=new JDialog(this,"Message (WIN|LOSE|DRAW)",true);
		d.setLocation(500, 600);
		d.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		d.setSize(400,100);
		d.setLayout(new FlowLayout());
		d.add(new JLabel("Would you like to play again?"));
		d.add(button1);
		d.add(button2);
		d.setVisible(true);
	}
	// to reset game
	public void reset()
	{
	count=1;
		playerCheckValue=0;
		set_positionValue=10;
		cpuCheckValue=0;
		ifdoit=0;
		for(int h=0;h<9;h++)
		{
		pos[h]=(char)(h+97);
			}
		flag='j';
		search='n';
		player_move='j';
		player_move1='j';
		doItValue='j';
		randomValue='j';
		tempd='j';
		b1.setIcon(null);
		b2.setIcon(null);
		b3.setIcon(null);
		b4.setIcon(null);
		b5.setIcon(null);
		b6.setIcon(null);
		b7.setIcon(null);
		b8.setIcon(null);
		b9.setIcon(null);
		}
	
	public void check_clicked()
	{
		set_position();
		if (pos[set_positionValue]=='X'|| pos[set_positionValue]=='O')
		{
			JOptionPane.showConfirmDialog(null, "Do you want to proceed? Are you fine? lol sorry MOVE HAS BEEN MADE HERE ALREADY", "Are you ok?",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
		
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		// yes restart
			if(e.getSource()==button1)
		{
		d.setVisible(false);
			reset();
			if (user_first==false)
			{
				set_count();
				cpuMove();
			}
			}
			// end game
		else if(e.getSource()==button2)
		{
		d.setVisible(false);
			dispose();
			System.exit(0);
			}
			
			// for name register
			else if(e.getSource()==button3)
		{
		Player1Name=tf1.getText();
			Player2Name=tf2.getText();
			l1.setText(Player1Name+": "+playerScore);
			if(vsCpu==0)
			{
			l2.setText(Player2Name+": "+cpuScore);
				}
			
			}
		
		{
		if(e.getSource()==b1&&count%2!=0)
			{
			flag='a';
	//to check if player move is valid player ChekcValue returns 1.
	// then it calls the set position value
	// which sets set_positionValue char to int 
	// then its pos[set_positionValue]= 0 or X 
			check_clicked();		
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b1.setIcon(cross);
					count++;
					checkWinner();
	// now check if win if not then now do cpu move
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
					}
			else if(e.getSource()==b2&&count%2!=0)
			{
			flag='b';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b2.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b3&&count%2!=0)
			{
			flag='c';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b3.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b4&&count%2!=0)
			{
			flag='d';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b4.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b5&&count%2!=0)
			{
			flag='e';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b5.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
						}
				}
			else if(e.getSource()==b6&&count%2!=0)
			{
			flag='f';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b6.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b7&&count%2!=0)
			{
			flag='g';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b7.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b8&&count%2!=0)
			{
			flag='h';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b8.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
					}
				}
			else if(e.getSource()==b9&&count%2!=0)
			{
			flag='i';
			check_clicked();
				playerCheck();
				if(playerCheckValue==1)
				{
				playerCheckValue=0;
					b9.setIcon(cross);
					count++;
					checkWinner();
					if(checkWinnerValue!=1)
					{
					cpuMove();
						}
						}
				}
		
	// if cpu turn and cpu returns sest_positionValue(a in this case) 
			if(set_positionValue==0&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b1.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==1&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b2.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==2&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b3.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==3&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b4.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==4&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b5.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==5&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b6.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==6&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b7.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==7&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b8.setIcon(criss);
						count++;
					}
				}
			else if(set_positionValue==8&&count%2==0)
			{
			if(checkWinnerValue!=1)
				{
				b9.setIcon(criss);
						count++;
					}
				}
			}
		
			
		
		
		if(count==1)
		{
		l3.setText("");
		}
		// if more than 4 moves than check winner in every move
		// this is because when 2 user and 2 comp moves then there cant be a move
		// this is only for a user vs user 
		if(count>4)
		{
		checkWinner();
		}
		// when player wins
		if(checkWinnerValue==1)
		{
			// when human wins
		if(checkWinnerPlayer==1)
			{
			playerScore++;
				l1.setText(Player1Name+": "+playerScore);
				checkWinnerPlayer=0;
				}
		// when computer wins
			else if(checkWinnerCpu==1)
			{
			cpuScore++;
				l2.setText(Player2Name+": "+cpuScore);
				checkWinnerCpu=0;
				}
			checkWinnerValue=0;
			dialogs();
			}
		
		
		
// menu buttons

		
		// when radio button is changed
		try
		{
			JRadioButtonMenuItem mbutton = (JRadioButtonMenuItem) e.getSource();
			if(mbutton.getText().equals("Player First"))
			{
				reset();
				playerScore=0;
				cpuScore=0;
				tf1.setText("PLAYER");
				tf2.setText("CPU");
				Player1Name=tf1.getText();
				Player2Name=tf2.getText();
				l1.setText(Player1Name+": "+playerScore);
				l2.setText(Player2Name+": "+cpuScore);
				l4.setIcon(ttt2);
				user_first=true;
				}
			else if(mbutton.getText().equals("Computer First"))
			{
				reset();
				playerScore=0;
				cpuScore=0;
				tf1.setText("PLAYER 1");
				tf2.setText("CPU");
				Player1Name=tf1.getText();
				Player2Name=tf2.getText();
				l1.setText(Player1Name+": "+playerScore);
				l2.setText(Player2Name+": "+cpuScore);
				l4.setIcon(ttt7);
				user_first=false;
				set_count();
				cpuMove();
				}
			// swaping corss with criss
			else if(mbutton.getText().equals("Cross"))
			{
			if(crossSwap==0)
				{
				ImageIcon newi=criss;
					criss=cross;
					cross=newi;
					crossSwap=1;
					crissSwap=0;
					reset();
					}
				}
			// swapping cross
			else if(mbutton.getText().equals("Criss"))
			{
			if(crissSwap==0)
				{
				ImageIcon newi=criss;
					criss=cross;
					cross=newi;
					crossSwap=0;
					crissSwap=1;
					reset();
					}
		}
		}
		catch (ClassCastException e1)
		{
			System.out.println("Player and comp Move Successfull");
		}
		
		
		
	}
		
	public static void main(String[] args)
	{

		TTT f=new TTT();
		f.setTitle("Tic Tac Toe Game");
		f.setSize(1000,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	
}


