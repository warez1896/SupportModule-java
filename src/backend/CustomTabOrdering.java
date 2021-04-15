package backend;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

public class CustomTabOrdering extends FocusTraversalPolicy {
	Vector<Component> componentOrder;

	public CustomTabOrdering(Vector<Component> componentOrder) {
		// TODO Auto-generated constructor stub
		this.componentOrder = new Vector<>(componentOrder.size());
		this.componentOrder.addAll(componentOrder);
	}

	@Override
	public Component getComponentAfter(Container aContainer, Component aComponent) {
		// TODO Auto-generated method stub
		int index = (componentOrder.indexOf(aComponent) + 1) % componentOrder.size();
		return componentOrder.get(index);
	}

	@Override
	public Component getComponentBefore(Container aContainer, Component aComponent) {
		// TODO Auto-generated method stub
		int index = componentOrder.indexOf(aComponent) - 1;
		// resets to last of order
		if (index < 0) {
			index = componentOrder.size() - 1;
		}
		return componentOrder.get(index);
	}

	@Override
	public Component getDefaultComponent(Container aContainer) {
		// TODO Auto-generated method stub
		return componentOrder.get(0);
	}

	@Override
	public Component getFirstComponent(Container aContainer) {
		// TODO Auto-generated method stub
		return componentOrder.get(0);
	}

	@Override
	public Component getLastComponent(Container aContainer) {
		// TODO Auto-generated method stub
		return componentOrder.lastElement();
	}
}
