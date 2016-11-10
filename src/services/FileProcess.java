package services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileProcess {
	public void writeUser(String name, String user, String pass,String domain)
	{
		FileWriter writer =null;
		try 
		{
			writer =new FileWriter("UserAccounts.txt",true);
				
			writer.write(name);
			writer.write("\r\n");
			writer.write(user);
			writer.write("\r\n");
			writer.write(pass);
			writer.write("\r\n");
			writer.write(domain);
			writer.write("\r\n");
			writer.write("=======================================");
			writer.write("\r\n");
			writer.write("\r\n");
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Unable to Open File"+e.getLocalizedMessage());
		}
		try
		{
			writer.close();
		}
		catch(Exception err)
		{
			JOptionPane.showMessageDialog(null, "Unable to Close File"+err.getLocalizedMessage());
		}
	}
	
	public void writeUpdates(ArrayList<String> list){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("/UserAccounts.txt"));
			for(String x : list){
					writer.write(x);
					writer.newLine();
			}
			writer.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Unable to Open File.\nError: "+e.getLocalizedMessage());
			}
	}
	
	public void updateFile(String search, String Update, String rewrite){
		File users=new File("UserAccounts.txt");
		String strholder="";                     //THIS VARIABLE HOLDS EACH LINE THAT IS READ IN FROM THE FILE
		int count=0;
		ArrayList<String> Temps =new ArrayList<String>();
		try
		{
			Scanner inFile = new Scanner(users);  //GETS THE INPUT FROM FILE
			while(inFile.hasNext()) 				  //LOOPS THROUGHT THE FILE WHILE IT HAS A NEXT LINE
			{
				strholder=inFile.nextLine();
				Temps.add(strholder);					//ADDS EACH LINE FROM THE FILE TO ARRAYLIST
			}
			inFile.close();
			
			users.delete();							//DELET'S OLD FILE TO BE REPLACE WITH UPDATED FILE
			for(int l=0;l<Temps.size(); l++)
			{
				try
				{
					if(Temps.get(l+1).contains(search))
					{
						if(rewrite.equals("NO"))
						{
							Temps.set(l+1, Update);
							count++;
						}
						else
						{
							Temps.set(l+2, Update);
							count++;
						}
						
					}
				
				}
				catch(Exception err)
				{
					JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while Updating file.\nError: "+err.getMessage());
				}
			}
			writeUpdates(Temps);    //SENDS OFF ARRYLIST TO BE WRITTEN BACK TO FILE
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while reading file.\nError: "+e.getMessage());
		}
		if(count==0)
		{
			JOptionPane.showMessageDialog(null, "Opps.. "+search+" Was not found in file.. Please Try Again");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Update Completed.");
		}
		Temps.clear();//CLEARS THE LIST
	}
	
	public int validate(String name, String user, String pass, String confirmpass, String update,String domain)
	{
		String alpha= "[a-zA-Z]+";
		String num="[0-9]+";
		try
		{
			if(pass.length()<8||pass.length()>25)
			{
				JOptionPane.showMessageDialog(null, "Check password length!.. A minimum of 6 or a maximum of 25 characters are required");
			}
			else if(pass.matches(alpha)==true || pass.matches(num)==true) 
			{
				JOptionPane.showMessageDialog(null, "Password Must be Alphanumeric!.. Containing at least one letter or number");
			}
			else if(pass.equals(confirmpass)==false)
			{
				JOptionPane.showMessageDialog(null, "Passwords didn't Match... Try Again!");
			}
			else
			{
				if(update.equals("NO")){
					
					int check= LookUPUser(user);
					if(check==0){
						JOptionPane.showMessageDialog(null, "Username Already Exist!");
						return 1;
						
					}else{
						JOptionPane.showMessageDialog(null, "Account Created!!");
						writeUser(name, user,pass,domain);
					}
					return 0;
				}else if(update.equals("YES")){
					String str="Password: "+pass;
					updateFile(user,str,"YES");
					return 0;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	public void Delete(String search)
	{
		File users=new File("UserAccounts.txt");
		String strholder="";							//THIS VARIABLE HOLDS EACH LINE THAT IS READ IN FROM THE FILE
		int count =0;
		ArrayList<String> Temps =new ArrayList<String>();
		try
		{
			Scanner inFile = new Scanner(users);    //GETS THE INPUT FROM FILE
			while(inFile.hasNext())   				//LOOPS THROUGHT THE FILE WHILE IT HAS A NEXT LINE
			{
				strholder=inFile.nextLine();
				Temps.add(strholder);				//ADDS EACH LINE FROM THE FILE TO ARRAYLIST
			}
			inFile.close();            
			for(int l=0;l<Temps.size(); l++)
			{
				try
				{
					if(Temps.get(l).contains(search)) //CHECKS EACH INDEX ALONG SITE THE RECORD TO DELETE 
					{
						Temps.set(l,"");           //DELETE'S THE RECORD 
						Temps.set(l+1, "");
						Temps.set(l+2, "");
						count++;					 //COUNTING HOW MUCH RECORDS WERE DELETED
					}
				}
				catch(Exception err)
				{
					JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while Updating file.\nError: "+err.getMessage());
				}
			}
			users.delete();
			writeUpdates(Temps);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while reading file.\nError: "+e.getMessage());
		}
		if(count==0)   //IF WHAT WE SEARCHED FOR WAS NOT IN THE FILE TO DELETE
		{
			JOptionPane.showMessageDialog(null, "Opps.. "+search+" Was not found in file.. Please Try Again");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Update Completed.\n"+count+" records were Updated");
			Temps.clear();
		}
	}
	
	public int fileLookUP(String user, String pass, String domain)
	{
		try
		{
			String strholder="";
			Scanner inFile = new Scanner(new File("UserAccounts.txt"));
			List<String> Temps =new ArrayList<String>();
			
			while(inFile.hasNext())
			{
				strholder=inFile.nextLine();
				Temps.add(strholder);
			}
			inFile.close();
			for(int i=0;i<Temps.size();i++)
			{
				if(Temps.get(i+1).contains(user)&&Temps.get(i+2).equals(pass)&&Temps.get(i+3).equals(domain))
				{
					return 0;
				}
			}
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while looking up user in file.\n Error: "+e.getMessage());
		}
		return -1;
	}	
	public int LookUPUser(String user)
	{
		try
		{
			String strholder="";
			Scanner inFile = new Scanner(new File("UserAccounts.txt"));
			List<String> Temps =new ArrayList<String>();
			
			while(inFile.hasNext())
			{
				strholder=inFile.nextLine();
				Temps.add(strholder);
			}
			inFile.close();
			for(int i=0;i<Temps.size();i++)
			{
				if(Temps.get(i+1).equals(user))
				{
					Temps.clear();
					return 0;
				}
			}
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(null, "Opps.. Somthing went wrong while looking up user in file.\n Error: "+e.getMessage());
		}
		return -1;
	}	
}
