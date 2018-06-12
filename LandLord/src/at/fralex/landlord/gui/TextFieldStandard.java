package at.fralex.landlord.gui;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldStandard extends JTextField {

	public TextFieldStandard(int length) {
		this(null, length);
	}

	public TextFieldStandard(String text, int length) {
		super(new PlainDocumentMaxLength(length), text, length);
	}
}

class PlainDocumentMaxLength extends PlainDocument {
	private int maxLength;

	public PlainDocumentMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
		if (getLength() + str.length() > maxLength) {
			
		} else {
			super.insertString(offset, str, a);
		}
	}
}
