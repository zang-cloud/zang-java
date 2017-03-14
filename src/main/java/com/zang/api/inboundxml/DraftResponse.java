package com.zang.api.inboundxml;

import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.exceptions.ZangException;
import com.zang.api.inboundxml.elements.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.math.BigInteger;

public class DraftResponse {

    private static Marshaller jaxbMarshaller;
    private static Unmarshaller jaxbUnmarshaller;
    private static Schema schema;

    static {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Response.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(new File(DraftResponse.class.getResource("/inboundxml.xsd").getFile()));
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbUnmarshaller.setSchema(schema);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    private Response response;

    DraftResponse() {
        response = new Response();
    }

    public String build() throws ZangException {
        if (schema == null || jaxbMarshaller == null || jaxbUnmarshaller == null) {
            throw new ZangException("Couldn't initialize JAXB");
        }
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(response, baos);
            String resultXml = baos.toString("UTF8");
            //test xml
            jaxbUnmarshaller.unmarshal(new StringReader(resultXml));
            return resultXml;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ZangException(ex.getMessage());
        }
    }

    public DraftResponse say(Say say) {
        response.getContent().add(say);
        return this;
    }

    public DraftResponse say(String text, SayVoice voice, TtsLanguages language, BigInteger loop) {
        Say say = new Say();
        say.setLanguage(language);
        say.setContent(text);
        say.setVoice(voice);
        say.setLoop(loop);
        return this.say(say);
    }

    public DraftResponse sms(Sms sms) {
        response.getContent().add(sms);
        return this;
    }

    public DraftResponse sms(String text, String action, String to, String from, HttpMethod method,
                             String statusCallback, HttpMethod statusCallbackMethod) {
        Sms sms = new Sms();
        sms.setContent(text);
        sms.setTo(to);
        sms.setFrom(from);
        sms.setAction(action);
        sms.setMethod(method != null ? method.toString() : null);
        sms.setStatusCallback(statusCallback);
        sms.setStatusCallbackMethod(statusCallbackMethod != null ? statusCallbackMethod.toString() : null);
        return this.sms(sms);
    }

    public DraftResponse sip(Sip sip) {
        response.getContent().add(sip);
        return this;
    }

    public DraftResponse sip(String sipAddress, String action, HttpMethod method, String username, String password, String sendDigits) {
        Sip sip = new Sip();
        sip.setContent(sipAddress);
        sip.setAction(action);
        sip.setMethod(method != null ? method.toString() : null);
        sip.setUsername(username);
        sip.setPassword(password);
        sip.setSendDigits(sendDigits);
        return this.sip(sip);
    }



}
