package pokemon;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Battel {
    JFrame frame = new JFrame("Pokemon");
    //글자 크기 조절하면서 글자 가운데 맞춤
    java.awt.Font font = new java.awt.Font("맑은 고딕", java.awt.Font.BOLD, 30);
    int WIDTH=1200;
    int HEIGHT=800;
    int level=0;
    Pokemonster player1=new Pokemonster(null, null, HEIGHT, HEIGHT, WIDTH, level, HEIGHT);
    Pokemonster player2=new Pokemonster(null, null, HEIGHT, HEIGHT, WIDTH, level, HEIGHT);
    int player_pokemon=0;
    String player_name = "플레이어";
    String enemy_name = "라이벌";
    public Battel(String player_name, String enemy_name) {
        this.player_name = player_name;
        this.enemy_name = enemy_name;
        JLabel select_label = new JLabel(player_name+"님 포켓몬을 선택하세요", JLabel.CENTER);
        //선택 라벨 폰트 변경
        select_label.setFont(font);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        //포켓몬 선택 화면
        frame.getContentPane().setLayout(null);
        //피카츄 선택 버튼
        JButton btn1 = new JButton("피카츄");
        btn1.setBounds(200,300,200,50);
        btn1.setBackground(java.awt.Color.YELLOW);
        frame.getContentPane().add(btn1);
        //피카츄 선택 버튼위에 피카츄 사진
        JLabel pikachu = new JLabel(new javax.swing.ImageIcon("./image/pikachu_menu.png"));
        pikachu.setBounds(200, 100, 200, 200);
        frame.getContentPane().add(pikachu);
        //파이리 선택 버튼
        JButton btn2 = new JButton("파이리");
        btn2.setBounds(800,300,200,50);
        btn2.setBackground(java.awt.Color.RED);
        frame.getContentPane().add(btn2);
        //파이리 선택 버튼위에 파이리 사진
        JLabel fire = new JLabel(new javax.swing.ImageIcon("./image/pikachu_menu.png"));
        fire.setBounds(800, 100, 200, 200);
        frame.getContentPane().add(fire);
        //이상해씨 선택 버튼
        JButton btn3 = new JButton("이상해씨");
        btn3.setBounds(200,600,200,50);
        btn3.setBackground(java.awt.Color.GREEN);
        frame.getContentPane().add(btn3);
        //이상해씨 선택 버튼위에 이상해씨 사진
        JLabel bulbasaur = new JLabel(new javax.swing.ImageIcon("./image/pikachu_menu.png"));
        bulbasaur.setBounds(200, 400, 200, 200);
        frame.getContentPane().add(bulbasaur);
        //꼬부기 선택 버튼
        JButton btn4 = new JButton("꼬부기");
        btn4.setBounds(800,600,200,50);
        btn4.setBackground(java.awt.Color.BLUE);
        frame.getContentPane().add(btn4);
        //꼬부기 선택 버튼위에 꼬부기 사진
        JLabel squirtle = new JLabel(new javax.swing.ImageIcon("./image/pikachu_menu.png"));
        squirtle.setBounds(800, 400, 200, 200);
        frame.getContentPane().add(squirtle);
        //포켓몬을 선택하세요 텍스트 상단에 띄우기
        select_label.setBounds(150, 50, 800, 100);
        frame.getContentPane().add(select_label);
        //피카츄 선택 버튼 이벤트
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                //플레이어의 포켓몬은 피카츄
                player_pokemon=0;
                //포켓몬 선택 화면을 지우고
                //난이도 선택
                JLabel select_label2 = new JLabel("난이도를 선택하세요");
                select_label2.setBounds(500, 50, 200, 50);
                frame.getContentPane().add(select_label2);
                //초급 난이도 버튼
                JButton b_btn1 = new JButton("초급");
                b_btn1.setBounds(300,100,600,200);
                b_btn1.setBackground(java.awt.Color.YELLOW);
                frame.getContentPane().add(b_btn1);
                //중급 난이도 버튼
                JButton b_btn2 = new JButton("중급");
                b_btn2.setBounds(300,300,600,200);
                b_btn2.setBackground(java.awt.Color.RED);
                frame.getContentPane().add(b_btn2);
                //고급 난이도 버튼
                JButton b_btn3 = new JButton("고급");
                b_btn3.setBounds(300,500,600,200);
                b_btn3.setBackground(java.awt.Color.GREEN);
                frame.getContentPane().add(b_btn3);
                //뒤로가기 버튼 생성
                JButton back_btn = new JButton("뒤로가기");
                back_btn.setBounds(1000, 700, 150, 50);
                frame.getContentPane().add(back_btn);
                //뒤로가기 버튼을 누르면 포켓몬 선택 화면으로 돌아감
                back_btn.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().setLayout(null);
                        frame.getContentPane().add(btn1);
                        frame.getContentPane().add(btn2);
                        frame.getContentPane().add(btn3);
                        frame.getContentPane().add(btn4);
                        frame.getContentPane().add(select_label);
                    }
                });
                //초급 난이도 버튼을 선택하면 level = 1 로 설정하고 배틀 화면 메소드 실행
                b_btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 1;
                        battle(level, player_pokemon);
                    }
                });
                //중급 난이도 버튼을 선택하면 level = 2 로 설정하고 배틀 화면 메소드 실행
                b_btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 2;
                        battle(level, player_pokemon);
                    }
                });
                //고급 난이도 버튼을 선택하면 level = 3 로 설정하고 배틀 화면 메소드 실행
                b_btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 3;
                        battle(level, player_pokemon);
                    }
                });


        }});
        //파이리 선택 버튼 이벤트
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                //포켓몬 선택 화면을 지우고
                //난이도 선택
                //플레이어의 포켓몬은 파이리
                player_pokemon=1;
                JLabel select_label2 = new JLabel("난이도를 선택하세요");
                select_label2.setBounds(500, 50, 200, 50);
                frame.getContentPane().add(select_label2);
                //초급 난이도 버튼
                JButton b_btn1 = new JButton("초급");
                b_btn1.setBounds(300,100,600,200);
                b_btn1.setBackground(java.awt.Color.YELLOW);
                frame.getContentPane().add(b_btn1);
                //중급 난이도 버튼
                JButton b_btn2 = new JButton("중급");
                b_btn2.setBounds(300,300,600,200);
                b_btn2.setBackground(java.awt.Color.RED);
                frame.getContentPane().add(b_btn2);
                //고급 난이도 버튼
                JButton b_btn3 = new JButton("고급");
                b_btn3.setBounds(300,500,600,200);
                b_btn3.setBackground(java.awt.Color.GREEN);
                frame.getContentPane().add(b_btn3);
                //뒤로가기 버튼 생성
                JButton back_btn = new JButton("뒤로가기");
                back_btn.setBounds(1000, 700, 150, 50);
                frame.getContentPane().add(back_btn);
                //뒤로가기 버튼을 누르면 포켓몬 선택 화면으로 돌아감
                back_btn.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().setLayout(null);
                        frame.getContentPane().add(btn1);
                        frame.getContentPane().add(btn2);
                        frame.getContentPane().add(btn3);
                        frame.getContentPane().add(btn4);
                        frame.getContentPane().add(select_label);
                    }
                });
                //초급 난이도 버튼을 선택하면 level = 1 로 설정하고 배틀 화면 메소드 실행
                b_btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 1;
                        battle(level, player_pokemon);
                    }
                });
                //중급 난이도 버튼을 선택하면 level = 2 로 설정하고 배틀 화면 메소드 실행
                b_btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 2;
                        battle(level, player_pokemon);
                    }
                });
                //고급 난이도 버튼을 선택하면 level = 3 로 설정하고 배틀 화면 메소드 실행
                b_btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 3;
                        battle(level,player_pokemon);
                    }
                });
        }});
        //이상해씨 선택 버튼 이벤트
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                //포켓몬 선택 화면을 지우고
                //플레이어의 포켓몬은 이상해씨
                player_pokemon=2;
                //난이도 선택
                JLabel select_label2 = new JLabel("난이도를 선택하세요");
                select_label2.setBounds(500, 50, 200, 50);
                frame.getContentPane().add(select_label2);
                //초급 난이도 버튼
                JButton b_btn1 = new JButton("초급");
                b_btn1.setBounds(300,100,600,200);
                b_btn1.setBackground(java.awt.Color.YELLOW);
                frame.getContentPane().add(b_btn1);
                //중급 난이도 버튼
                JButton b_btn2 = new JButton("중급");
                b_btn2.setBounds(300,300,600,200);
                b_btn2.setBackground(java.awt.Color.RED);
                frame.getContentPane().add(b_btn2);
                //고급 난이도 버튼
                JButton b_btn3 = new JButton("고급");
                b_btn3.setBounds(300,500,600,200);
                b_btn3.setBackground(java.awt.Color.GREEN);
                frame.getContentPane().add(b_btn3);
                //뒤로가기 버튼 생성
                JButton back_btn = new JButton("뒤로가기");
                back_btn.setBounds(1000, 700, 150, 50);
                frame.getContentPane().add(back_btn);
                //뒤로가기 버튼을 누르면 포켓몬 선택 화면으로 돌아감
                back_btn.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().setLayout(null);
                        frame.getContentPane().add(btn1);
                        frame.getContentPane().add(btn2);
                        frame.getContentPane().add(btn3);
                        frame.getContentPane().add(btn4);
                        frame.getContentPane().add(select_label);
                    }
                });
                //초급 난이도 버튼을 선택하면 level = 1 로 설정하고 배틀 화면 메소드 실행
                b_btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 1;
                        battle(level, player_pokemon);
                    }
                });
                //중급 난이도 버튼을 선택하면 level = 2 로 설정하고 배틀 화면 메소드 실행
                b_btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 2;
                        battle(level, player_pokemon);
                    }
                });
                //고급 난이도 버튼을 선택하면 level = 3 로 설정하고 배틀 화면 메소드 실행
                b_btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 3;
                        battle(level, player_pokemon);
                    }
                });
        }});
        //꼬부기 선택 버튼 이벤트
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                //포켓몬 선택 화면을 지우고
                //플레이어의 포켓몬은 꼬부기
                player_pokemon=3;
                //난이도 선택
                JLabel select_label2 = new JLabel("난이도를 선택하세요");
                select_label2.setBounds(500, 50, 200, 50);
                frame.getContentPane().add(select_label2);
                //초급 난이도 버튼
                JButton b_btn1 = new JButton("초급");
                b_btn1.setBounds(300,100,600,200);
                b_btn1.setBackground(java.awt.Color.YELLOW);
                frame.getContentPane().add(b_btn1);
                //중급 난이도 버튼
                JButton b_btn2 = new JButton("중급");
                b_btn2.setBounds(300,300,600,200);
                b_btn2.setBackground(java.awt.Color.RED);
                frame.getContentPane().add(b_btn2);
                //고급 난이도 버튼
                JButton b_btn3 = new JButton("고급");
                b_btn3.setBounds(300,500,600,200);
                b_btn3.setBackground(java.awt.Color.GREEN);
                frame.getContentPane().add(b_btn3);
                //뒤로가기 버튼 생성
                JButton back_btn = new JButton("뒤로가기");
                back_btn.setBounds(1000, 700, 150, 50);
                frame.getContentPane().add(back_btn);
                //뒤로가기 버튼을 누르면 포켓몬 선택 화면으로 돌아감
                back_btn.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().setLayout(null);
                        frame.getContentPane().add(btn1);
                        frame.getContentPane().add(btn2);
                        frame.getContentPane().add(btn3);
                        frame.getContentPane().add(btn4);
                        frame.getContentPane().add(select_label);
                    }
                });
                //초급 난이도 버튼을 선택하면 level = 1 로 설정하고 배틀 화면 메소드 실행
                b_btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 1;
                        battle(level,player_pokemon);
                    }
                });
                //중급 난이도 버튼을 선택하면 level = 2 로 설정하고 배틀 화면 메소드 실행
                b_btn2.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 2;
                        battle(level,player_pokemon);
                    }
                });
                //고급 난이도 버튼을 선택하면 level = 3 로 설정하고 배틀 화면 메소드 실행
                b_btn3.addActionListener(new ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        level = 3;
                        battle(level,player_pokemon);
                    }
                });
        }});

    }
    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    //난이도 값을 입력 받는 배틀 화면 메소드
    public void battle(int level,int pokemon) {
        //배틀 화면 생성
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.getContentPane().setLayout(null);
        //만약 level = 1 이면 초급 난이도
        if(level == 1){
            //pokemon의 값에 따라 포켓몬 객체 생성
            if(pokemon == 0){
                player1 = new Pokemonster("피카츄", "전기", 30, 10, 100, 5, 30);
                player2 = new Pokemonster("꼬부기", "물", 10, 5, 100, 3, 10);
            }
            else if(pokemon == 1){
                player1 = new Pokemonster("파이리", "불", 40, 5, 90, 5, 20);
                player2 = new Pokemonster("이상해씨", "풀", 10, 5, 90, 3, 10);
            }
            else if(pokemon == 2){
                player1 = new Pokemonster("이상해씨", "풀", 20, 15, 110, 5, 15);
                player2 = new Pokemonster("꼬부기", "물", 10, 5, 100, 3, 10);
            }
            else if(pokemon == 3){
                player1 = new Pokemonster("꼬부기", "물", 35, 10, 120, 5, 10);
                player2 = new Pokemonster("파이리", "불", 10, 5, 100, 3, 10);
            }
            //포켓몬의 체력바 생성
            JLabel hp_label = new JLabel("HP : " + player1.getHp()+" / "+player1.getMaxHp());
            hp_label.setBounds(900,430,100,50);
            frame.getContentPane().add(hp_label);
            //포켓몬의 이름 생성
            JLabel name_label = new JLabel(player1.getName());
            name_label.setBounds(900,380,100,50);
            frame.getContentPane().add(name_label);
            //라이벌 포켓몬의 체력바 생성
            JLabel hp_label2 = new JLabel("HP : " + player2.getHp()+" / "+player2.getMaxHp());
            hp_label2.setBounds(100, 100, 100, 50);
            frame.getContentPane().add(hp_label2);
            //라이벌 포켓몬의 이름 생성
            JLabel name_label2 = new JLabel(player2.getName());
            name_label2.setBounds(100, 50, 100, 50);
            frame.getContentPane().add(name_label2);
            //공격버튼 생성
            JButton attack_btn = new JButton("공격");
            attack_btn.setBounds(200, 500, 400, 90);
            frame.getContentPane().add(attack_btn);
            //공격버튼을 누르면 공격을 실행함 (아직 미구현)
            attack_btn.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //공격을 실행하고 나면 스피드가 빠른 포켓몬이 먼저 공격함
                    if(player1.getSpeed() > player2.getSpeed()){
                        player1.attack(player2);
                        player2.attack(player1);
                        //공격을 실행하고 나면 체력바를 갱신함
                        hp_label.setText("HP : " + player1.getHp()+" / "+player1.getMaxHp());
                        hp_label2.setText("HP : " + player2.getHp()+" / "+player2.getMaxHp());
                        //만약 라이벌 포켓몬의 체력이 0이하가 되면 승리하였습니다! 라는 메시지를 출력하고 메인 화면으로 돌아감
                        if(player2.getHp() <= 0){
                            JOptionPane.showMessageDialog(null, "승리하였습니다!");
                            setVisible(false);
                            Pokemon pokemon = new Pokemon();
                            pokemon.go();
                        }
                        //만약 내 포켓몬의 체력이 0이하가 되면 패배하였습니다! 라는 메시지를 출력하고 메인 화면으로 돌아감
                        else if(player1.getHp() <= 0){
                            JOptionPane.showMessageDialog(null, "패배하였습니다!");
                            setVisible(false);
                            Pokemon pokemon = new Pokemon();
                            pokemon.go();
                    }
                    else{
                        player2.attack(player1);
                        player1.attack(player2);
                        hp_label.setText("HP : " + player1.getHp()+" / "+player1.getMaxHp());
                        hp_label2.setText("HP : " + player2.getHp()+" / "+player2.getMaxHp());
                        if(player2.getHp() <= 0){
                            JOptionPane.showMessageDialog(null, "승리하였습니다!");
                            setVisible(false);
                            Pokemon pokemon = new Pokemon();
                            pokemon.go();
                        }
                        else if(player1.getHp() <= 0){
                        JOptionPane.showMessageDialog(null, "패배하였습니다!");
                        setVisible(false);
                        Pokemon pokemon = new Pokemon();
                        pokemon.go();
                        }
                    }
        }}});
            //회복버튼 생성
            JButton heal_btn = new JButton("회복");
            heal_btn.setBounds(600, 500, 400, 90);
            frame.getContentPane().add(heal_btn);
            //회복버튼을 누르면 회복을 실행함 (아직 미구현)
            heal_btn.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //회복버튼을 누르면 본인이 선택한 포켓몬의 체력이 10만큼 회복하고 상대는 공격을 함
                    player1.recover();
                    //플레이어는 포켓몬을 회복시켰다 라는 메세지 출력후 체력바 갱신
                    JOptionPane.showMessageDialog(null, "포켓몬을 회복시켰다!");
                    hp_label.setText("HP : " + player1.getHp()+" / "+player1.getMaxHp());
                    //상대는 공격을 함
                    player2.attack(player1);
                    //상대가 공격을 하고 나면 체력바를 갱신함
                    hp_label2.setText("HP : " + player2.getHp()+" / "+player2.getMaxHp());
                    //만약 내 포켓몬의 체력이 0이하가 되면 패배하였습니다! 라는 메시지를 출력하고 메인 화면으로 돌아감
                    if(player1.getHp() <= 0){
                        JOptionPane.showMessageDialog(null, "패배하였습니다!");
                        setVisible(false);
                        Pokemon pokemon = new Pokemon();
                        pokemon.go();
                    }
                }
            });
            //도망버튼 생성
            JButton run_btn = new JButton("도망");
            run_btn.setBounds(200, 590, 800, 90);
            frame.getContentPane().add(run_btn);
            //도망버튼을 누르면 도망을 실행함 (아직 미구현)
            run_btn.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //도망 칠수 없었다는 메시지 출력
                    JOptionPane.showMessageDialog(null, "도망칠 수 없습니다.");
                }
            });
            
        }
        else if(level == 2){
            
        }
        else if(level == 3){
    
        }

    }






}
