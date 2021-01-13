package org.BG.DAO;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.ProposalMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProposalDao {
    @Autowired
    SqlSession sqlSession;
    public ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto){
        ArrayList<ProposalDto> proposalDto = new ArrayList<>();
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            proposalDto = proposalMapper.appRetrieveProposalList(userDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return proposalDto;
    }

    public ProposalDto appRetrieveProposalDetailOfChangeEatVerProposal(ProposalDto proposalDto){
        ProposalDto proposalDto2 = new ProposalDto();
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            proposalDto2 = proposalMapper.appRetrieveProposalDetailOfChangeEatVerProposal(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return proposalDto2;
    }
    public ProductDto appRetrieveProposalDetailOfChangeEatVerMyProduct(ProposalDto proposalDto){
        ProductDto productDto = new ProductDto();
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            productDto = proposalMapper.appRetrieveProposalDetailOfChangeEatVerMyProduct(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return productDto;
    }

    public ProductDto appRetrieveProposalDetailOfChangeEatVerYourProduct(ProposalDto proposalDto){
        ProductDto productDto = new ProductDto();
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            productDto = proposalMapper.appRetrieveProposalDetailOfChangeEatVerYourProduct(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return productDto;
    }
    public UserDto appRetrieveProposalDetailOfChangeEatVerUser(ProposalDto proposalDto){
        UserDto userDto2 = new UserDto();
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            userDto2 = proposalMapper.appRetrieveProposalDetailOfChangeEatVerUser(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return userDto2;
    }

    public String appChangeStateOfProposal(ProposalDto proposalDto){
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            proposalMapper.appChangeStateOfProposal(proposalDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int countProposalOfChange(){
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            return proposalMapper.countProposalOfChange();
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int countProposalOfCall(){
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            return proposalMapper.countProposalOfCall();
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public String appRegisterProposal(ProposalDto proposalDto){
        try{
            ProposalMapper proposalMapper = sqlSession.getMapper(ProposalMapper.class);
            proposalMapper.appRegisterProposal(proposalDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
