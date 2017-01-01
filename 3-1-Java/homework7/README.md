# ����˵��

��Ҫ��Ʋο���������ͼ��

![Class Diagram](Class-Diagram.png)

������ͼ�����Щ���㣬ʵ������м����޸ģ�

- `interface Observer` �е� `update(Sale) : void` �޸�Ϊ `update() : void`
  - ��ʹ��ԭ��ƣ��� `interface Subject` ������ `Observer`����`Observer` ������ `Sale implements Subject` Ϊ `Subject` ��һ��ʵ�֣��⽫���� `Subject` �����塣
  - ʵ������У�ͨ�� `controller` ���� `Sale` �� `ShoppingCartUI` ��ԭͼ����Ϊ `ShoppingCarUI`����
- `interface IPricingStrategy` �е� `getSubTotal(SaleLineItem) : double` �޸�Ϊ `getSubTotal(copies, bookSpecification) : double`
  - ��ʹ��ԭ��ƣ��� `interface IPricingStrategy` ������ `SaleLineItem`���� `SaleLineItem` ӵ�� `IPricingStrategy` ʵ�ֵĶ��󣻼���۸�ʱ��`IPricingStrategy` ʵ�������� `SaleLineItem` �� `getCopies` `getBookSpecification`��
  - ʵ������У�ͨ��ֱ�Ӵ��� `copies, bookSpecification` ��� `interface IPricingStrategy` �� `SaleLineItem` ֮���**ǿ���**��
- �ϲ��� `Controller` �е� `addCompositeStrategy` `addSimpleStrategy` `updateStrategy`��
- ������ `BuyUI` �� `ShoppingCartUI` �Ĺ�����**Association**��
  - ԭ�����û�е����� `ShoppingCartUI` ����ơ�
- ɾȥ�� `CompositeBestForCustomer`
  - ԭ����ĵ���û���ἰ���ࡣ

���ಿ�ֻ���**���ղ���չ**ԭ���ͼ��