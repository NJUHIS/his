package com.njuhis.his.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njuhis.his.mapper.*;
import com.njuhis.his.model.*;
import com.njuhis.his.util.QuickLogger;
import com.njuhis.his.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInformationService {
    private QuickLogger quickLogger =new QuickLogger(this.getClass());
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private PersonalInformationService personalInformationService;
    @Autowired
    private ConstantItemMapper constantItemMapper;
    @Autowired
    private ConstantTypeMapper constantTypeMapper;
    @Autowired
    private ExpenseClassMapper expenseClassMapper;
    @Autowired
    private SettleCategoryMapper settleCategoryMapper;
    @Autowired
    private RegisterLevelMapper registerLevelMapper;
    @Autowired
    private SchedulingMapper schedulingMapper;

    public List<Department> getAllDepartments(ResultMessage resultMessage){
        return departmentMapper.selectAll();
    }

    /**
     * @param user user 的 id 會從無到有
     */
    public User addUser(User user, ResultMessage resultMessage){
        personalInformationService.makeSureUserUsernameNotExist(user.getUsername(),resultMessage);
        if(!resultMessage.isSuccessful()) return null;

        try {
            userMapper.insert(user);
            return user;
        }catch (Exception exception){
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public List<User> getUsersBetweenScheduleDates(Long startDate, Long endDate,int pageNumber, int pageSize,  ResultMessage resultMessage){
        //TODO 邏輯待補充完整

        //下面作為PageHelper的使用範例
//        PageHelper.startPage(pageNumber,pageSize);
//        List<User> userList=userMapper.selectAll();
//        return new PageInfo(userList);

        List<User> userList=userMapper.selectAll();
        return userList;

    }

    public List<Patient> getPatientsBetweenScheduleDates(Long startDate, Long endDate,int pageNumber, int pageSize,  ResultMessage resultMessage){
        //TODO 邏輯待補充完整

        return patientMapper.selectAll();
    }

    public Department addDepartment(Department department, ResultMessage resultMessage){
        try {
            departmentMapper.insert(department);
            return department;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public Department getDepartmentById(Integer id, ResultMessage resultMessage){
        Department department=departmentMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(department!=null){
            return department;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.DEPARTMENT_NOT_EXIST);
            return null;
        }

    }

    public Department updateDepartment(Department department, ResultMessage resultMessage){
        getDepartmentById(department.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                departmentMapper.updateByPrimaryKey(department);
                return getDepartmentById(department.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

   



    public List<ConstantItem> getAllConstantItems(ResultMessage resultMessage){
        return constantItemMapper.selectAll();
    }


    public ConstantItem addConstantItem(ConstantItem constantItem,ResultMessage resultMessage){
        try {
            constantItemMapper.insert(constantItem);
            return constantItem;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public ConstantItem getConstantItemById(Integer id, ResultMessage resultMessage){
        ConstantItem constantItem=constantItemMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(constantItem!=null){
            return constantItem;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.CONSTANT_ITEM_NOT_EXIST);
            return null;
        }
    }


    public ConstantItem updateConstantItem(ConstantItem constantItem, ResultMessage resultMessage){
        getConstantItemById(constantItem.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                constantItemMapper.updateByPrimaryKey(constantItem);
                return getConstantItemById(constantItem.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }


        public List<ConstantType> getAllConstantTypes(ResultMessage resultMessage){
        return constantTypeMapper.selectAll();
    }

    public ConstantType addConstantType(ConstantType constantType,ResultMessage resultMessage){
        try {
            constantTypeMapper.insert(constantType);
            return constantType;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    public ConstantType getConstantTypeById(Integer id, ResultMessage resultMessage){
        ConstantType constantType=constantTypeMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(constantType!=null){
            return constantType;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.CONSTANT_TYPE_NOT_EXIST);
            return null;
        }

    }


    public ConstantType updateConstantType(ConstantType constantType, ResultMessage resultMessage){
        getConstantTypeById(constantType.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                constantTypeMapper.updateByPrimaryKey(constantType);
                return getConstantTypeById(constantType.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }



    public List<ExpenseClass> getAllExpenseClasses(ResultMessage resultMessage){
        return expenseClassMapper.selectAll();
    }


    public ExpenseClass addExpenseClass(ExpenseClass expenseClass,ResultMessage resultMessage){
        try {
            expenseClassMapper.insert(expenseClass);
            return expenseClass;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public ExpenseClass getExpenseClassById(Integer id, ResultMessage resultMessage){
        ExpenseClass expenseClass=expenseClassMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(expenseClass!=null){
            return expenseClass;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.EXPENSE_TYPE_NOT_EXIST);
            return null;
        }

    }

    //TODO 待测试
    public ExpenseClass updateExpenseClass(ExpenseClass expenseClass, ResultMessage resultMessage){
        getExpenseClassById(expenseClass.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                expenseClassMapper.updateByPrimaryKey(expenseClass);
                return getExpenseClassById(expenseClass.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }




    public List<SettleCategory> getAllSettleCategories(ResultMessage resultMessage){
        return settleCategoryMapper.selectAll();
    }


    public SettleCategory addSettleCategory(SettleCategory settleCategory,ResultMessage resultMessage){
        try {
            settleCategoryMapper.insert(settleCategory);
            return settleCategory;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public SettleCategory getSettleCategoryById(Integer id, ResultMessage resultMessage){
        SettleCategory settleCategory=settleCategoryMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(settleCategory!=null){
            return settleCategory;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.SETTLEMENT_TYPE_NOT_EXIST);
            return null;
        }

    }


    public SettleCategory updateSettleCategory(SettleCategory settleCategory, ResultMessage resultMessage){
        getSettleCategoryById(settleCategory.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                settleCategoryMapper.updateByPrimaryKey(settleCategory);
                return getSettleCategoryById(settleCategory.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }




    public List<RegisterLevel> getAllRegisterLevels(ResultMessage resultMessage){
        return registerLevelMapper.selectAll();
    }


    public RegisterLevel addRegisterLevel(RegisterLevel registerLevel,ResultMessage resultMessage){
        try {
            registerLevelMapper.insert(registerLevel);
            return registerLevel;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }


    public RegisterLevel getRegisterLevelById(Integer id, ResultMessage resultMessage){
        RegisterLevel registerLevel=registerLevelMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(registerLevel!=null){
            return registerLevel;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.REGISTRATION_TYPE_NOT_EXIST);
            return null;
        }

    }


    public RegisterLevel updateRegisterLevel(RegisterLevel registerLevel, ResultMessage resultMessage){
        getRegisterLevelById(registerLevel.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                registerLevelMapper.updateByPrimaryKey(registerLevel);
                return getRegisterLevelById(registerLevel.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }

        //TODO 待测试
    public List<Scheduling> getAllSchedulings(ResultMessage resultMessage){
        return schedulingMapper.selectAll();
    }

    //TODO 待测试
    public Scheduling addScheduling(Scheduling scheduling,ResultMessage resultMessage){
        try {
            schedulingMapper.insert(scheduling);
            return scheduling;
        } catch (Exception exception) {
            exception.printStackTrace();
            resultMessage.setUnknownError();
            return null;
        }
    }

    //TODO 待测试
    public Scheduling getSchedulingById(Integer id, ResultMessage resultMessage){
        Scheduling scheduling=schedulingMapper.selectByPrimaryKey(id);//如果失败，并不会抛出异常，只会返回null。
        if(scheduling!=null){
            return scheduling;
        }else{
            resultMessage.setClientError(ResultMessage.ErrorMessage.SCHEDULE_NOT_EXIST);
            return null;
        }

    }

    //TODO 待测试
    public Scheduling updateScheduling(Scheduling scheduling, ResultMessage resultMessage){
        getSchedulingById(scheduling.getId(),resultMessage);
        if(resultMessage.isSuccessful()) {//如果 id 存在
            try {
                schedulingMapper.updateByPrimaryKey(scheduling);
                return getSchedulingById(scheduling.getId(),resultMessage);
            } catch (Exception exception) {
                exception.printStackTrace();
                resultMessage.setUnknownError();
                return null;
            }
        }else{
            return null;
        }
    }



}
