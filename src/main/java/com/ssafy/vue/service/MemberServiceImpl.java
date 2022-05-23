package com.ssafy.vue.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;


    @Override
    public MemberDto login(MemberDto memberDto) throws Exception {
        if (memberDto.getUserid() == null || memberDto.getUserpwd() == null)
            return null;

        MemberDto findById = memberMapper.selectInfo(memberDto.getUserid());
        if(findById == null){
            return null;
        }

        if(BCrypt.checkpw(memberDto.getUserpwd(),findById.getUserpwd())){
            findById.setUserpwd(memberDto.getUserpwd());
            return findById;
        }

        return null;
    }

    @Override
    public MemberDto selectInfo(String userid) throws Exception {
        return memberMapper.selectInfo(userid);
    }

    @Override
    public int updateInfo(MemberDto memberDto) throws Exception {
        return memberMapper.updateInfo(memberDto);
    }

    @Override
    public int deleteInfo(String userId) throws Exception {
        return memberMapper.deleteInfo(userId);
    }

    @Override
    public int insertInfo(MemberDto memberDto) throws Exception {
        memberDto = hasingPassword(memberDto);
        return memberMapper.insertInfo(memberDto);
    }

    public MemberDto hasingPassword(MemberDto memberDto){
        String userPassword = memberDto.getUserpwd();
        String hashedPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        memberDto.setUserpwd(hashedPassword);
        return memberDto;
    }

    @Override
    public boolean checkMemberIsDuplicate(String userId) throws Exception {
        MemberDto findById = memberMapper.selectInfo(userId);
        if(findById == null){
            return false;
        }
        return true;
    }


}
