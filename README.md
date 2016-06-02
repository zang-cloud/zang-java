zang-java
==========

This java library is an open source tool built to simplify interaction with the [Zang](http://www.zang.io) telephony platform. Zang makes adding voice and SMS to applications fun and easy.

For more information about Zang, please visit: [zang.io/features](http://www.zang.io/features) or [zang.io/docs](http://www.zang.io/docs)

---


Installation
============

Clone the repo, and install via [maven](http://maven.apache.org/download.html):
```
$ git clone git@github.com:zang-cloud/zang-java.git
$ cd zang-java
$ mvn install
```

To use this library, include the following dependency within pom.xml:

```
<dependency>
  <groupId>com.zang.api</groupId>
  <artifactId>zang-java</artifactId>
  <version>0.0.1</version>
</dependency>
```


Usage
======

### REST

[Zang REST API documenatation](http://www.zang.io/docs/api/rest/)

##### Send SMS Example

```java
package com.zang.api.example;

import com.zang.api.ZangConnector;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.domain.SmsMessage;
import com.zang.api.exceptions.ZangException;

public class SendSmsExample {
    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("********************************");
        conf.setAuthToken("********************************");
        ZangConnector conn = new ZangConnector(conf);

        try {
            SmsMessage smsMessage = conn.sendSmsMessage(
                "(XXX) XXX-XXXX",
                "(XXX) XXX-XXXX",
                "This is an SMS message sent from the Zang Java helper! Easy as 1, 2, 3!",
                null
            );
            System.out.println(smsMessage.getSid());
        } catch (ZangException e) {
            e.printStackTrace();
        }
    }
}         
```

### InboundXML

InboundXML is an XML dialect which enables you to control phone call flow. For more information please visit the [Zang InboundXML documenatation](http://www.zang.io/docs/api/inboundxml/)

##### <Say> Example

```java
package com.zang.api.inboundxml.example;

import com.zang.api.inboundxml.elements.Response;
import com.zang.api.inboundxml.elements.enums.Voice;

public class SayExample {

public static void main(String[] args) {

    Response.create()
        .say("Welcome to Zang. This is a sample InboundXML document.", Voice.MAN)
        .createXml();

    }

}   
```

will render

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response>
  <Say voice="man">Welcome to Zang. This is a sample InboundXML document.</Say>
</Response>
```

---
