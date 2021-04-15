package javacode03.gobang;

import java.util.Arrays;
import java.util.Scanner;
/**
 * �Զ���������
 * @author Administrator
 *
 */
public class FiveChess {
	
	//����������
	
	static String[][] srr = new String[20][20];
	static FiveChess chess = new FiveChess();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String g = "��λ";
		String result = "���";
		chess.getChess();
		System.out.println("��ʼ��Ϸ");
		for (int i = 0; i < srr.length*srr.length; i++) {
			chess.showChess();
			if(i%2==0) {
				System.out.println("�׷�����");
				System.out.println("��ѡ������λ��(��  x,y ��ʽ)��");
				g = input.next();
				result = chess.setChess(g,"��");
				System.out.println(result);
				if(result.equals("�����ʽ����")) {
					i--;
				}else if(result.equals("��ʤ����!")){
					break;
				}
			}else {
				System.out.println("�ڷ�����");
				System.out.println("��ѡ������λ��(��  x,y ��ʽ)��");
				g = input.next();
				result = chess.setChess(g,"��");
				System.out.println(result);
				if(result.equals("�����ʽ����")) {
					i--;
				}else if(result.equals("��ʤ����!")){
					break;
				}
			}
			System.out.println();
		}
		System.out.println("��ֽ�����");
	}

	
	public void showChess() {//����չʾ
		for (int i = 0; i < srr.length; i++) {
			System.out.print("+---");
		}
		System.out.println("+");
		for (int i = 0; i < srr.length; i++) {
			System.out.print("|");
			for (int j = 0; j < srr[i].length; j++) {
				System.out.print("   |");
			}
			System.out.println();
			for (int l = 0; l < srr.length; l++) {
				System.out.print("+---");
			}
			System.out.println("+");
		}
	}
	
	public void getChess() {//����Ԥ��
		for (int i = 0; i < srr.length; i++) {
			for (int j = 0; j < srr[i].length; j++) {
				srr[i][j] = " ";
			}
		}
	}
	
	public String setChess(String g, String chess) {
		if(!g.matches("\\d\\d?,\\d\\d?")) {
			return "�����ʽ����";
		}
		String[] c = g.split(",");
		int x = Integer.parseInt(c[0]);
		int	y = Integer.parseInt(c[1]);
		if((x-1)>20||(x-1)<1||(y-1)>20||(x-1)<1) {
			return "�����ʽ����";
		}
		srr[x-1][y-1] = chess;
		if(end(chess, x, y)) {
			return chess+"ʤ����!";
		}
		return "���ӳɹ�";
	}
	
	public boolean end(String g, int x, int y) {//�Ƿ���ʤ��
		if(across(g, x, y)==5||protrait(g, x, y)==5||leftSprit(g, x, y)==5||rightSprit(g, x, y)==5) {
			return true;
		}
		return false;
	}
	
	public int across(String g, int x, int y) {//���ж�
		int num = 1;
		for (int i = 0; i < 5; i++) {
			y++;
			if(y<=20&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		for (int i = 0; i < 5; i++) {
			y--;
			if(y>=1&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		return num;
	}
	
	public int protrait(String g, int x, int y) {//���ж�
		int num = 1;
		for (int i = 0; i < 5; i++) {
			x++;
			if(x<=20&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		for (int i = 0; i < 5; i++) {
			x--;
			if(x>=1&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		return num;
	}
	
	public int rightSprit(String g, int x, int y) {//��б�ж�
		int num = 1;
		for (int i = 0; i < 5; i++) {
			y++;x++;
			if((y<=20||x<=20)&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		for (int i = 0; i < 5; i++) {
			y--;x--;
			if((y>=1||x>=1)&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		return num;
	}
	
	public int leftSprit(String g, int x, int y) {//��б�ж�
		int num = 1;
		for (int i = 0; i < 5; i++) {
			y++;x--;
			if((y<=20||x>=1)&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		for (int i = 0; i < 5; i++) {
			y--;x++;
			if((y>=1||x<=20)&&srr[x-1][y-1].equals(g)) {
				num++;
			}else {
				break;
			}	
		}
		return num;
	}
}
