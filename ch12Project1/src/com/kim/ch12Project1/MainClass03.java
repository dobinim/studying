package com.kim.ch12Project1;

public class MainClass03 {

	public static void main(String[] args) {
		// enum�� �ν��Ͻ��� enum�̸� �ν��Ͻ������� ����
		Direction d1;
		// enum �ν��Ͻ��� �� ���� �� enum�̸�.����̸�
		d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST"); 
		// ������� WEST�� enum ��ü�� ���ϴ� �޼���
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1==d2? " + (d1 == d2));
		// �񱳿��� ==�� ����
		System.out.println("d1==d3? " + (d1 == d3));
		System.out.println("d1.equals(d3)? " + d1.equals(d3));
		// equals�� ��� ����
		// System.out.println("d2 > d3? " + (d1 > d3)); // == �� �ƴ� �� ������ �Ұ�����
		System.out.println("d1.compareTo(d3)? " + (d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2)? " + (d1.compareTo(d2)));
		// �� ������ ���� compareTo�޼���� ��� ����(���� ������ 0, +, -��)
		
		switch(d1) {
		case EAST:
			System.out.println("The direction is EAST.");
			break;
		case SOUTH:
			System.out.println("The direction is SOUTH.");
			break;
		case WEST:
			System.out.println("The direction is WEST.");
			break;
		case NORTH:
			System.out.println("The direction is NORTH.");
			break;
		default :
			System.out.println("Invalid direction.");
			break;
		}
		
		Direction[] dArr = Direction.values();
		for(Direction d : dArr) {
			System.out.println("name : " + d.name());
			System.out.println("value : " + d.ordinal());
		}
		
		
	}
}

enum Direction { 	// �������� enum �������̸� { }
	// ����� ����. ����̹Ƿ� ��� �빮�ڷ� �̸� �ۼ�
	// �ڵ����� ���� 0���� ������� �־�����
	EAST
	,SOUTH
	,WEST
	,NORTH
	
}