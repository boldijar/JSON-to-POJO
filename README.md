# JSON to POJO 

### API

 Post to /json/{root} with the body of the json you want, and content type text/plain.
 
 
 Where root is the name of the root class.
 
 
Example: 

```javascript
POST http://app-leaderboards.rhcloud.com/parser/json/MyClass HTTP/1.1
Host: app-leaderboards.rhcloud.com
Connection: keep-alive
Content-Length: 138
Content-Type: text/plain

{
  number: "2015",
  doubleNumber: "1.34",
  text: "hey",
  bool: "true",
  vector3: {
    x: 123,
    y: 134,
    z: 451
  }
}
```

If the json is valid you'll get a json array with class name and class text:

```javascript
 [
  {
    "filename": "MyClass.java",
    "text": "public class MyClass{\nprivate String text;\nprivate Long number;\nprivate Boolean bool;\nprivate Double doubleNumber;\nprivate Vector3 vector3;\n\npublic String getText() {\nreturn text;\n}\npublic void setText(String text){\nthis.text=text;\n}\npublic Long getNumber() {\nreturn number;\n}\npublic void setNumber(Long number){\nthis.number=number;\n}\npublic Boolean getBool() {\nreturn bool;\n}\npublic void setBool(Boolean bool){\nthis.bool=bool;\n}\npublic Double getDoubleNumber() {\nreturn doubleNumber;\n}\npublic void setDoubleNumber(Double doubleNumber){\nthis.doubleNumber=doubleNumber;\n}\npublic Vector3 getVector3() {\nreturn vector3;\n}\npublic void setVector3(Vector3 vector3){\nthis.vector3=vector3;\n}\n}"
  },
  {
    "filename": "Vector3.java",
    "text": "public class Vector3{\nprivate Long z;\nprivate Long y;\nprivate Long x;\n\npublic Long getZ() {\nreturn z;\n}\npublic void setZ(Long z){\nthis.z=z;\n}\npublic Long getY() {\nreturn y;\n}\npublic void setY(Long y){\nthis.y=y;\n}\npublic Long getX() {\nreturn x;\n}\npublic void setX(Long x){\nthis.x=x;\n}\n}"
  }
]
```

