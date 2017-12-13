/**
 *  Copyright (c) 2017 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - [CodeMining] Provide extension point for CodeMining - Bug 528419
 */
package org.eclipse.jface.text.codemining;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.reconciler.Reconciler;

/**
 * A reconciler which update code minings.
 *
 * @since 3.13
 */
public class CodeMiningReconciler extends Reconciler {

	private CodeMiningStrategy fStrategy;

	public CodeMiningReconciler() {
		super.setIsIncrementalReconciler(false);
		fStrategy= new CodeMiningStrategy();
		this.setReconcilingStrategy(fStrategy, IDocument.DEFAULT_CONTENT_TYPE);
	}

	@Override
	public void install(ITextViewer textViewer) {
		super.install(textViewer);
		fStrategy.install(textViewer);
	}

	@Override
	public void uninstall() {
		super.uninstall();
		fStrategy.uninstall();
	}

}
