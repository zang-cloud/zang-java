zang-java
==========

This java library is an open source tool built to simplify interaction with the [Zang](http://www.zang.io) telephony platform. Zang makes adding voice and SMS to applications fun and easy.

For more information about Zang, please visit: [Zang Cloud](https://www.zang.io/products/cloud)

To read the official documentation, please visit: [Zang Docs](http://docs.zang.io/aspx/docs)

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
  <version>1.1.0</version>
</dependency>
```


Usage
======

### REST

See the [Zang REST API documentation](http://docs.zang.io/aspx/rest) for more information.

#### Send SMS Example

```java
package com.zang.api.examples;
import com.zang.api.configuration.BasicZangConfiguration;
import com.zang.api.connectors.SmsConnector;
import com.zang.api.connectors.ZangConnectorFactory;
import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.list.SmsMessageList;
import com.zang.api.exceptions.ZangException;

public class SmsExample {

    public static void main(String[] args) {
        BasicZangConfiguration conf = new BasicZangConfiguration();
        conf.setSid("{AccountSid}");
        conf.setAuthToken("{AuthToken}");
        SmsConnector conn = ZangConnectorFactory.getSmsConnector(conf);

        //send sms message
        try {
            SmsMessage sentSmsMessage = conn
                    .sendSmsMessage(
                            "(XXX) XXX-XXXX",
                            "(XXX) XXX-XXXX",
                            "This is an SMS message sent from the Zang Java helper! Easy as 1, 2, 3!",
                            null, null, null);
            System.out.println(sentSmsMessage.getStatus());
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }
}
        
```
#### Configuration

First a configuration must be created by using one of the provided configuration classes (`BasicZangConfiguration`, `PropertiesFileZangConfiguration`) or by creating your own implementation with the `ZangConfiguration` interface.

Normally you'll want to just enter your Zang Platform *AccountSid* and *AuthToken*, but you can also define a proxy server or change the base API URL.

Next you'll have to create a connector by using `ZangConnectorFactory`. This can be done in multiple ways. The usual way is to instantiate `ZangConnectorFactory`, pass the configuration object to the factory and have it instantiate `ZangConnector` objects:
```java
ZangConnectorFactory zangConnectorFactory = new ZangConnectorFactory(conf);
CallsConnector callsConnector = zangConnectorFactory.getCallsConnector();
callsConnector.makeCall(...);
```
Alternatively you can create a connector directly like this:
```java
CallsConnector callsConnector = ZangConnectorFactory.getCallsConnector(conf);
```
Besides the configuration parameter you can also specify a custom `ClientHttpEngine` both for the whole factory or for a specific connector. If a custom `ClientHttpEngine` is used, the proxy server configuration parameters aren't used. 

#### Request parameters
Request parameters are passed as parameters to connector object methods as shown previously. All methods have convenience overloads which use the `AccountSid` parameter specified in the configuration automatically:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
//explicit accountSid
Usage usage = connector.viewUsage("{accountSid}", "{UsageSid}");
//accountSid from configuration used automatically
Usage usage = connector.viewUsage("{UsageSid}");
```
Methods with a large number of possible parameters have convenience builder objects, e.g.:
```java
CallsConnector connector = connectorFactory.getCallsConnector();
Call call = connector.makeCall(MakeCallParams.builder()
	.setTo("+123456")
    .setFrom("+654321")
    .setUrl("{InboundXmlUrl}")
    .setRecord(true)
    .setRecordCallback("{RecordCallbackUrl}")
    .build()
);
```

#### Response data
The received data can be an object, e.g.:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
Usage usage = connector.viewUsage("{UsageSid}");
System.out.println(usage.getTotalCost());
```
Or a list of objects in which case the list is iterable, e.g.:
```java
UsagesConnector connector = connectorFactory.getUsagesConnector();
ListUsagesParams params = ListUsagesParams.builder()
	.setPage(0)
    .setPageSize(25)
    .setProduct(Product.OUTBOUND_SMS)
    .setDay(12)
    .setMonth(12)
    .setYear(2016)
    .build();
    
UsagesList list = connector.listUsages(params);
for(Usage usage : list) {
	System.out.println(usage.getTotalCost());
}

```


### InboundXML

InboundXML is an XML dialect which enables you to control phone call flow. For more information please visit the [Zang InboundXML documentation](http://docs.zang.io/aspx/inboundxml).

##### <Say> Example

```java
package com.zang.api.examples;

import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.ZangInboundXml;
import com.zang.api.inboundxml.elements.Say;
import com.zang.api.inboundxml.elements.enums.Language;
import com.zang.api.inboundxml.elements.enums.Voice;

public class InboundXmlExample {

    public static void main(String[] args) {
        try {
            String result = ZangInboundXml.builder()
                    .say(Say.builder()
                            .setLanguage(Language.EN)
                            .setLoop(3)
                            .setText("Welcome to Zang!")
                            .setVoice(Voice.FEMALE)
                            .build())
                    .build()
                    .toXml();
            System.out.println(result);
        } catch (ZangException e) {
            e.printStackTrace();
        }

    }

}
 
```

will render

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Response>
    <Say loop="3" voice="female" language="en">Welcome to Zang!</Say>
</Response>
```

