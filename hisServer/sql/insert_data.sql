INSERT INTO his.registlevel (id, RegistName, RegistFee, DelMark) VALUES (100, '普通号', 20.00, 0);
INSERT INTO his.registlevel (id, RegistName, RegistFee, DelMark) VALUES (101, '专家号', 50.00, 0);
INSERT INTO his.registlevel (id, RegistName, RegistFee, DelMark) VALUES (102, '急诊号', 100.00, 0);



INSERT INTO his.settlecategory (id, SettleName, DelMark) VALUES (100, '自费', 0);
INSERT INTO his.settlecategory (id, SettleName, DelMark) VALUES (101, '医保', 0);
INSERT INTO his.settlecategory (id, SettleName, DelMark) VALUES (102, '农合', 0);


INSERT INTO his.patient (id, name, IDnumber, phone, loginname, gender, birthday, homeAddress, password) VALUES (100, 'Nelson', '123456198011101234', null, 'nelson', 1, '1980-11-10', 'Shanghai', 'password');


INSERT INTO his.user (id, UserName, Password, RealName, UserTypeID, DocTitleID, IsScheduling, DeptId, RegistId, DelMark, IDnumber) VALUES (100, 'robin', 'password', 'Robin', 2, 1, null, 1, 100, 0, null);
INSERT INTO his.user (id, UserName, Password, RealName, UserTypeID, DocTitleID, IsScheduling, DeptId, RegistId, DelMark, IDnumber) VALUES (101, 'mike', 'password', 'Mike', 1, null, null, null, null, 0, null);


INSERT INTO his.scheduling (id, SchedDate, DeptId, UserId, Noon, RegistQuota, State, remainingQuota) VALUES (100, '2020-12-02', 1, 100, 1, 30, 3, 3);



























