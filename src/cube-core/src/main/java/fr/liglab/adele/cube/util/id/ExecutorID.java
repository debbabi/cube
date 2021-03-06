/*
 * Copyright 2011 Adele Team LIG (http://www-adele.imag.fr/)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.liglab.adele.cube.util.id;

public class ExecutorID extends CubeAgentID {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4782855619709425672L;

	private static int index=0;
	
	private String name = null;
	
	public ExecutorID(CubeID ciid) throws InvalidIDException {
		super(ciid);
		String hierar = ciid.getHierarchicalPart();
		if (hierar.contains("/ex/")) {
			this.name = hierar.substring(hierar.lastIndexOf("/"), hierar.length());
		}
	}
		
	public ExecutorID(CubeAgentID ciid, String name) throws InvalidIDException  {
		super(ciid);				
		String hierar = ciid.getHierarchicalPart();				
		if (hierar.contains("/ex/")) {
			throw new InvalidIDException("Invalid ScopeLeaderID!");
		}
		if (name != null) {
			this.name = name;
		} else {
			this.name = "" + index++;
		}
	}
	
	public String getLocalId() {
		return this.name;
	}
		
	public static boolean check(CubeID id) {	
		if (id != null) {
			if (id.getHierarchicalPart().contains("/ex/")) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return super.getURI() + "/ex/" + name;
	}
}
