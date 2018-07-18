package org.anhu.usb;

import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

public class ReadUSB {

	// Port_#0003.Hub_#0002

	public static void main(String[] args) {
		try {
			// Display the list of terminals
			TerminalFactory factory = TerminalFactory.getDefault();
			List<CardTerminal> terminals = factory.terminals().list();
			System.out.println("Terminals: " + terminals);

			// Use the first terminal
			CardTerminal terminal = terminals.get(0);

			// Connect wit hthe card
			Card card = terminal.connect("*");
			System.out.println("card: " + card);
			CardChannel channel = card.getBasicChannel();

			// Send Select Applet command
			byte[] aid = { (byte) 0xA0, 0x00, 0x00, 0x00, 0x62, 0x03, 0x01, 0x0C, 0x06, 0x01 };
			ResponseAPDU answer = channel.transmit(new CommandAPDU(0x00, 0xA4, 0x04, 0x00, aid));
			System.out.println("answer: " + answer.toString());

			// Send test command
			answer = channel.transmit(new CommandAPDU(0x00, 0x00, 0x00, 0x00));
			System.out.println("answer: " + answer.toString());
			byte r[] = answer.getData();
			for (int i = 0; i < r.length; i++)
				System.out.println((char) r[i]);
			System.out.println();

			// Disconnect the card
			card.disconnect(false);
		} catch (Exception e) {
			System.out.println("Ouch: " + e.toString());
		}
	}

}
