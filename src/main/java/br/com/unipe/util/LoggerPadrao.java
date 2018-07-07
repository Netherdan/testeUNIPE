package br.com.unipe.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.SentryClientFactory;

public class LoggerPadrao {
	
	private static Logger logErro = LoggerFactory.getLogger("erros");
	private static Logger logInfo = LoggerFactory.getLogger("informacao");
	private static Logger logInfoStartApplication = LoggerFactory.getLogger("start_application");
	private static Logger logDebug = LoggerFactory.getLogger("depuracao");
	private static Logger logTransacao = LoggerFactory.getLogger("transacao");

	static {
		Sentry.init("https://545a1bbc956e4dd483db2b35d6a3b90f@sentry.io/1238316");
	}
	
	public static void info(String mensagem, Object ... args){
		logInfo.info(mensagem, args);
		Sentry.capture(mensagem);
	}
	
	public static void info(String mensagem){
		logInfo.info(mensagem);
		Sentry.capture(mensagem);
	}
	
	public static void transacao(String mensagem){
		String log = "loggerTransacao - "+mensagem;
		logTransacao.info(log);
		Sentry.capture(log);
	}
	
	public static void debug(String mensagem, Object ... args){
		logDebug.debug(mensagem, args);
		String log = "loggerDebug - "+mensagem;
		Sentry.capture(log);
	}
	
	public static void debug(String mensagem, long time){
		String log = mensagem+ " - "+(System.currentTimeMillis()-time)+" ms";
		logDebug.debug(log);
		Sentry.capture(log);
	}
	

	public static void error(String mensagem, Exception e) {
		logErro.error(mensagem, e);
		Sentry.capture(e);
	}

	public static void error(String string) {
		logErro.error(string);
		Sentry.capture(string);
	}
	
	public static void info(String mensagem, long time, Object ... args){
		String log = mensagem+" - "+(System.currentTimeMillis()-time)+" ms";
		logInfo.info(log, args);
		Sentry.capture(log);
	}
	
	public static void info(String mensagem, long time){
		String log = mensagem+ " - "+(System.currentTimeMillis()-time)+" ms";
		logInfo.info(log);
		Sentry.capture(log);
	}
	
	public static void transacao(String mensagem, long time){
		String log = "loggerTransacao - "+mensagem+" - "+(System.currentTimeMillis()-time)+" ms";
		logTransacao.info(log);
		Sentry.capture(log);
	}
	
	public static void debug(String mensagem, long time, Object ... args){
		String log = mensagem+" - "+(System.currentTimeMillis()-time)+" ms";
		logDebug.debug(log, args);
		Sentry.capture(log);
	}

	public static void error(String mensagem, Exception e, long time) {
		String log = mensagem+" - "+(System.currentTimeMillis()-time)+" ms";
		logErro.error(log, e);
		Sentry.capture(log);
		Sentry.capture(e);
	}

	public static void error(String string, long time) {
		String log = string+" - "+(System.currentTimeMillis()-time)+" ms";
		logErro.error(log);
		Sentry.capture(log);
	}
	
	public static void startApplication(String mensagem, Object ... args){
		logInfoStartApplication.info(mensagem, args);
		Sentry.capture(mensagem);
	}
}
