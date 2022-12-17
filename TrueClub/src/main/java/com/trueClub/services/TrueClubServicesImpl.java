package com.trueClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.trueClub.Entity.TrueClub;
import com.trueClub.exceptation.MemberExceptation;
import com.trueClub.repositery.TrueClubDao;

@Service
public class TrueClubServicesImpl implements TrueClubServices{

	
	//Reference variables touch to my data Access Layer
	@Autowired
	private TrueClubDao dao;
	
	

	//1. Save(Insert new Recode) the TrueClub Member On Database
	@Override
	public TrueClub saveMember(TrueClub trueClub) {
		
		TrueClub saveMember	=dao.save(trueClub);
		
		return saveMember;
	}


	
    //2. Get the recode base on giving id

	@Override
	public TrueClub getMemberByid(Integer id) throws MemberExceptation {

		Optional<TrueClub> opt =dao.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new MemberExceptation("Member does not Exist with Propre id: "+id);
		}
		
		//Other Way to Write logic
		//return opt.orElseThrow(()->new MemberExceptation("Member does not Exist with Propre id:"+id));
		
	}
	
	//3. Update the Recode
	@Override
	public TrueClub updateMemberDetails(TrueClub trueClub) throws MemberExceptation {
		
		//first check Member it should be there or not
		
		Optional<TrueClub> opt= dao.findById(trueClub.getId());
		
		if(opt.isPresent()) {
			
			return dao.save(trueClub);
			
			//here save method will perform as saveOrUpdate Based on Id field;
			
		}
		else {
			throw new MemberExceptation("Invalid Member details");
		}
		
	}
	
	
	
	//4. Delete the Recode on database
	
	@Override
	public TrueClub deleteMemberById(Integer id) throws MemberExceptation {
		//you can also use Optional 
		TrueClub existingMember= dao.findById(id).orElseThrow(()-> new MemberExceptation("Member does not exist wthi id"+id));
		
		return existingMember;
	}


	//5. Get All the TrueClubMember Recode

	@Override
	public List<TrueClub> getAllMemberRecode() throws MemberExceptation {
		
		//return dao.findAll();
		
		List<TrueClub> tcMember =dao.findAll();
		
		if(tcMember.size()>0) {
			return tcMember;
		}
		else {
			throw new MemberExceptation("No Memeber Found...");		
		}
		
	}

	
	
	

}
