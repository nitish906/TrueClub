package com.trueClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trueClub.Entity.TrueClub;
import com.trueClub.exceptation.MemberExceptation;
import com.trueClub.services.TrueClubServices;

@RestController
public class TrueClubController {
	
	//Reference variables to touch to service layer
	@Autowired
	private TrueClubServices services;



	//1. method Signature->ResponseEntity
	
	@PostMapping("/regMember")
	public ResponseEntity<TrueClub>registerStudentHandler(@RequestBody TrueClub trueClub){
		
		TrueClub saveMember= services.saveMember(trueClub);
		
		return new ResponseEntity<TrueClub>(saveMember,HttpStatus.CREATED);
	
	}
	
	// 2. Get the Recode base on giving id
	
	@GetMapping("regMember/{id}")
	public ResponseEntity<TrueClub> getMemberByIdHandler(@PathVariable("id") Integer id) throws MemberExceptation{
		
		 TrueClub trueClub= services.getMemberByid(id);
		 
		 return new ResponseEntity<TrueClub>(trueClub, HttpStatus.OK);
		 
	}
	//3.Update the Recode 
	@PutMapping("/member")
	public ResponseEntity<TrueClub> updateMemberByHandler(@RequestBody TrueClub trueClub) throws MemberExceptation{
		
		TrueClub updateMember= services.updateMemberDetails(trueClub);
		
		return new ResponseEntity<TrueClub>(updateMember, HttpStatus.OK);
		
	}
	
	
	//4. Delete the Recode
	
	@DeleteMapping("delMember/{id}")
	public ResponseEntity<TrueClub> deleteMemberByIdHandler(@PathVariable("id") Integer id) throws MemberExceptation{
		
		TrueClub deleteMember= services.deleteMemberById(id);
		
		return new ResponseEntity<TrueClub>(deleteMember,HttpStatus.OK);
	}
	
	
	//5. Get all TrueClub Member Recode
	
	@GetMapping("/findMember")
	public ResponseEntity<List<TrueClub>> getAllDetailsHandler() throws MemberExceptation {
		
		 List<TrueClub> trueClubs =services.getAllMemberRecode();
		
		
		return new ResponseEntity<List<TrueClub>>(trueClubs, HttpStatus.OK);
		
	}
	
	
	

}