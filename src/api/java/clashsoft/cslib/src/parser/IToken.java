package clashsoft.cslib.src.parser;

import clashsoft.cslib.src.SyntaxException;

public interface IToken
{
	byte	TYPE_IDENTIFIER		= 1;
	byte	TYPE_SYMBOL			= 2;
	byte	TYPE_BRACKET		= 3;
	
	byte	TYPE_INT			= 4;
	byte	TYPE_INT_HEX		= 5;
	byte	TYPE_INT_BIN		= 6;
	
	byte	TYPE_FLOAT			= 7;
	byte	TYPE_FLOAT_HEX		= 8;
	
	byte	TYPE_STRING			= 9;
	byte	TYPE_CHAR			= 10;
	
	byte	TYPE_LINE_COMMENT	= 11;
	byte	TYPE_BLOCK_COMMENT	= 12;
	
	String value() throws SyntaxException;
	
	byte type() throws SyntaxException;
	
	boolean equals(String value) throws SyntaxException;
	
	boolean isType(byte type) throws SyntaxException;
	
	int index() throws SyntaxException;
	
	int start() throws SyntaxException;
	
	int end() throws SyntaxException;
	
	IToken prev() throws SyntaxException;
	
	IToken next() throws SyntaxException;
	
	boolean hasPrev();
	
	boolean hasNext();
	
	void setIndex(int index);
	
	void setPrev(IToken prev);
	
	void setNext(IToken next);
}
