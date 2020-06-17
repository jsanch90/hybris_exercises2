package de.hybris.training.backoffice.actions;

import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.zkoss.zul.Messagebox;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

public class MyCreationDateAction implements CockpitAction {

    @Resource(name = "modelService")
    ModelService modelService;

    @Override
    public ActionResult perform(ActionContext actionContext) {

        ActionResult result = null;

        if(Objects.nonNull(actionContext)) {
            ProductModel product = (ProductModel) actionContext.getData();
            product.setMyCreationDate(new Date());
            modelService.save(product);
            result = new ActionResult(ActionResult.SUCCESS);
        }else{
            result = new ActionResult(ActionResult.ERROR);
        }
        Messagebox.show(result.getData() + " (" + result.getResultCode() + ")");

        return result;
    }

    @Override
    public boolean canPerform(ActionContext ctx) {
        final Object data = ctx.getData();
        return (data instanceof ProductModel);
    }

    @Override
    public boolean needsConfirmation(ActionContext ctx) {
        return true;
    }

    @Override
    public String getConfirmationMessage(ActionContext ctx) {
        return null;
    }
}
