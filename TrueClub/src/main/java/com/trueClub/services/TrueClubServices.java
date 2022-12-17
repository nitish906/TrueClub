package com.trueClub.services;


import java.util.List;

import com.trueClub.Entity.TrueClub;
import com.trueClub.exceptation.MemberExceptation;

public interface TrueClubServices {
	
	//Business Logic
	
	//1. Insert new Recode On the Database
	public TrueClub saveMember(TrueClub trueClub);
	
	
	//2. Get the recode base on givin id
	//if my Member should be not there after i use Exceptation
	public TrueClub getMemberByid(Integer id) throws MemberExceptation;
	
	
	//3. update the recode
	public TrueClub updateMemberDetails(TrueClub trueClub) throws MemberExceptation;
	
	
	//4. Delete the recode
	 public TrueClub deleteMemberById(Integer id) throws MemberExceptation;
	
	 
	//5. Get all recode
	public List<TrueClub> getAllMemberRecode() throws MemberExceptation;



}
