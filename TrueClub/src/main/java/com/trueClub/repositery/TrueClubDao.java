package com.trueClub.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trueClub.Entity.TrueClub;

//Integer Representing the Primary key that means Id field value of data type in int class;

@Repository
public interface TrueClubDao extends JpaRepository<TrueClub, Integer> {

}
