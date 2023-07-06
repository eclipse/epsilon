package org.eclipse.epsilon.picto.watermarking;

import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class WatermarkTrace {
		
		protected Object element;
		protected String property;
		protected IEolContext context;
		protected String watermark;
		
		public Object getElement() {
			return element;
		}
		
		public void setElement(Object element) {
			this.element = element;
		}
		
		public String getProperty() {
			return property;
		}
		
		public void setProperty(String property) {
			this.property = property;
		}
		
		public String getWatermark() {
			return watermark;
		}
		
		public void setWatermark(String watermark) {
			this.watermark = watermark;
		}
		
		public void setContext(IEolContext context) {
			this.context = context;
		}
		
		public IEolContext getContext() {
			return context;
		}
	}