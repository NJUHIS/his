To Paul
By Paul

- @JsonIgnore 有這個註解的變量意味著 Json 在做轉換的時候無視該變量。

  POJO -> Json：Json 中並不出現有@JsonIgnore 變量的字段。

  Json -> POJO : POJO 中有@JsonIgnore 的變量為 null，無論Json中是否包含該字段。

  在本項目中，要在保存從前端傳回的數據到數據庫時，要當心 delmark 變量，可能會以 null 覆蓋原來的數據。

  

- 對於 Spring Boot 中的 @RequestBody， 如果 Json 缺少一些字段，那麼 POJO 中的相應的變量就會為 null。所以在保存從前端傳回的數據到數據庫時，小心不要以null覆蓋原來的數據。Json 應當寫完整。

  
  
- 本項目中， Mapper.update() 方法，如果參數的 id 為null，或者為數據庫中不存在的 id，那麼數據庫中不會有改變，但是該方法並不會拋出異常或有其他的錯誤反饋。所以在update之前應該用select()來判斷該id是否存在。



- SpringBoot 鏈接數據庫時避免亂碼的方法：

  spring.datasource.url=jdbc:mysql://yeungfanstudio.com:3306/his?characterEncoding=utf8

  在後面聲名UTF-8。



- 
- 

