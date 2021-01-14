package backend;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class DecimalFilter extends DocumentFilter {
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {
		// TODO Auto-generated method stub
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.insert(offset, string);
		if (test(sb.toString().trim())) {
			super.insertString(fb, offset, string, attr);
		}
	}

	private boolean test(String text) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[0-9]|[\\.]|[0-9]");
		if (text.equals(""))
			return true;
		return pattern.matcher(text).matches();
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		// TODO Auto-generated method stub
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.replace(offset, offset + length, text);
		if (test(sb.toString().trim())) {
			super.replace(fb, offset, length, text, attrs);
		}
	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		// TODO Auto-generated method stub
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset, offset + length);
		if (test(sb.toString().trim())) {
			super.remove(fb, offset, length);
		}
	}

}
