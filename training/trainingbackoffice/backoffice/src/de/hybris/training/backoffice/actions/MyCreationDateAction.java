package de.hybris.training.backoffice.actions;

import com.hybris.cockpitng.actions.ActionContext;
import com.hybris.cockpitng.actions.ActionResult;
import com.hybris.cockpitng.actions.CockpitAction;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.EnumSet;

public class MyCreationDateAction implements CockpitAction<String, Object> {

    @Resource
    private CatalogVersionService catalogVersionService;

    @Resource
    private ProductService productService;

    @Resource
    private ModelService modelService;

    @Override
    public ActionResult<Object> perform(ActionContext<String> actionContext) {
        String productCode = actionContext.getData();
        ProductModel productModel = getProductService().getProductForCode(getStagedCatalog(), productCode);
        productModel.setMyCreationDate(new Date());
        getModelService().save(productModel);
        ActionResult result = new ActionResult<Object>(ActionResult.SUCCESS);
        result.setStatusFlags(EnumSet.of(ActionResult.StatusFlag.OBJECT_MODIFIED));
        return result;
    }

    @Override
    public boolean canPerform(ActionContext<String> ctx) {
        final Object data = ctx.getData();
        return (data instanceof String) && (!((String) data).isEmpty());
    }

    @Override
    public boolean needsConfirmation(ActionContext<String> ctx) {
        return true;
    }

    @Override
    public String getConfirmationMessage(ActionContext<String> ctx) {
        return ctx.getLabel("action.update.product.confirm");
    }

    private CatalogVersionModel getStagedCatalog(){
        return catalogVersionService.getCatalogVersion("electronicsProductCatalog", "Staged");
    }

    public CatalogVersionService getCatalogVersionService() {
        return catalogVersionService;
    }

    public void setCatalogVersionService(CatalogVersionService catalogVersionService) {
        this.catalogVersionService = catalogVersionService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
