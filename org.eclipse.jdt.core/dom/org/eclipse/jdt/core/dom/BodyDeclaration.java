/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.jdt.core.dom;

/**
 * Abstract base class of all AST nodes that represent body declarations 
 * that may appear in the body of some kind of class or interface declaration,
 * including anonymous class declarations, enumeration declarations, and
 * enumeration constant declarations.
 * 
 * <p>
 * <pre>
 * BodyDeclaration:
 *		ClassDeclaration
 *		InterfaceDeclaration
 *		EnumDeclaration
 *		MethodDeclaration
 * 		ConstructorDeclaration
 * 		FieldDeclaration
 * 		Initializer
 *		EnumConstantDeclaration
 * </pre>
 * </p>
 * <p>
 * Most types of body declarations can carry a Javadoc comment; Initializer
 * is the only ones that does not. The source range for body declarations
 * always includes the Javadoc comment if present.
 * </p>
 * 
 * @since 2.0
 */
public abstract class BodyDeclaration extends ASTNode {
	
	/**
	 * The Javadoc comment, or <code>null</code> if none.
	 * Defaults to none.
	 */
	private Javadoc optionalJavadoc = null;

	/**
	 * Creates a new AST node for a body declaration node owned by the 
	 * given AST.
	 * <p>
	 * N.B. This constructor is package-private.
	 * </p>
	 * 
	 * @param ast the AST that is to own this node
	 */
	BodyDeclaration(AST ast) {
		super(ast);
	}
	
	/**
	 * Returns the Javadoc comment node.
	 * 
	 * @return the javadoc comment node, or <code>null</code> if none
	 */
	public Javadoc getJavadoc() {
		return optionalJavadoc;
	}

	/**
	 * Sets or clears the Javadoc comment node.
	 * 
	 * @param javadoc the javadoc comment node, or <code>null</code> if none
	 * @exception IllegalArgumentException if the Java comment string is invalid
	 */
	public void setJavadoc(Javadoc javadoc) {
		replaceChild(this.optionalJavadoc, javadoc, false);
		this.optionalJavadoc = javadoc;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	int memSize() {
		return BASE_NODE_SIZE + 1 * 4;
	}
}

