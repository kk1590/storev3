package online.store.shop.service;

import online.store.pojo.TbSeller;
import online.store.sellergoods.service.TbSellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDitelServiceImpl implements UserDetailsService {

    /**
     * 将服务层通过spring bean 注入方式注入
     * 提供set方法
     */
    private TbSellerService tbSellerService;

    public void setTbSellerService(TbSellerService tbSellerService) {
        this.tbSellerService = tbSellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*创建用户列表*/
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        /*通过用户查询数据库得到seller对象*/
        TbSeller tbSeller = tbSellerService.selectByPrimaryKey(username);

        /*根据查询的结果角色名和密码赋值*/
        if(tbSeller!=null){
            if("1".equals(tbSeller.getStatus())){
                return new User(username,tbSeller.getPassword(),grantedAuthorities);
            }else {return null;}
        }else{
            return null;
        }
    }
}